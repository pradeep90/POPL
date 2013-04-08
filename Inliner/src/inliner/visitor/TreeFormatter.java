//
// Generated by JTB 1.3.2
//
package inliner.visitor;

import inliner.syntaxtree.*;
import java.util.*;

/**
 * A skeleton output formatter for your language grammar.  Using the
 * add() method along with force(), indent(), and outdent(), you can
 * easily specify how this visitor will format the given syntax tree.
 * See the JTB documentation for more details.
 *
 * Pass your syntax tree to this visitor, and then to the TreeDumper
 * visitor in order to "pretty print" your tree.
 */
public class TreeFormatter extends DepthFirstVisitor {
    private Vector<FormatCommand> cmdQueue = new Vector<FormatCommand>();
    private boolean lineWrap;
    private int wrapWidth;
    private int indentAmt;
    private int curLine = 1;
    private int curColumn = 1;
    private int curIndent = 0;

    /**
     * The default constructor assumes an indentation amount of 3 spaces
     * and no line-wrap.  You may alternately use the other constructor to
     * specify your own indentation amount and line width.
     */
    public TreeFormatter() { this(3, 0); }

    /**
     * This constructor accepts an indent amount and a line width which is
     * used to wrap long lines.  If a token's beginColumn value is greater
     * than the specified wrapWidth, it will be moved to the next line and
     * indented one extra level.  To turn off line-wrapping, specify a
     * wrapWidth of 0.
     *
     * @param   indentAmt   Amount of spaces per indentation level.
     * @param   wrapWidth   Wrap lines longer than wrapWidth.  0 for no wrap.
     */
    public TreeFormatter(int indentAmt, int wrapWidth) {
        this.indentAmt = indentAmt;
        this.wrapWidth = wrapWidth;

        if ( wrapWidth > 0 )
            lineWrap = true;
        else
            lineWrap = false;
    }

    /**
     * Accepts a NodeListInterface object and performs an optional format
     * command between each node in the list (but not after the last node).
     */
    protected void processList(NodeListInterface n) {
        processList(n, null);
    }

    protected void processList(NodeListInterface n, FormatCommand cmd) {
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            if ( cmd != null && e.hasMoreElements() )
                cmdQueue.addElement(cmd);
        }
    }

    /**
     * A Force command inserts a line break and indents the next line to
     * the current indentation level.  Use "add(force());".
     */
    protected FormatCommand force() { return force(1); }
    protected FormatCommand force(int i) {
        return new FormatCommand(FormatCommand.FORCE, i);
    }

    /**
     * An Indent command increases the indentation level by one (or a
     * user-specified amount).  Use "add(indent());".
     */
    protected FormatCommand indent() { return indent(1); }
    protected FormatCommand indent(int i) {
        return new FormatCommand(FormatCommand.INDENT, i);
    }

    /**
     * An Outdent command is the reverse of the Indent command: it reduces
     * the indentation level.  Use "add(outdent());".
     */
    protected FormatCommand outdent() { return outdent(1); }
    protected FormatCommand outdent(int i) {
        return new FormatCommand(FormatCommand.OUTDENT, i);
    }

    /**
     * A Space command simply adds one or a user-specified number of
     * spaces between tokens.  Use "add(space());".
     */
    protected FormatCommand space() { return space(1); }
    protected FormatCommand space(int i) {
        return new FormatCommand(FormatCommand.SPACE, i);
    }

    /**
     * Use this method to add FormatCommands to the command queue to be
     * executed when the next token in the tree is visited.
     */
    protected void add(FormatCommand cmd) {
        cmdQueue.addElement(cmd);
    }

    /**
     * Executes the commands waiting in the command queue, then inserts the
     * proper location information into the current NodeToken.
     *
     * If there are any special tokens preceding this token, they will be
     * given the current location information.  The token will follow on
     * the next line, at the proper indentation level.  If this is not the
     * behavior you want from special tokens, feel free to modify this
     * method.
     */
    public void visit(NodeToken n) {
        for ( Enumeration<FormatCommand> e = cmdQueue.elements(); e.hasMoreElements(); ) {
            FormatCommand cmd = e.nextElement();
            switch ( cmd.getCommand() ) {
                case FormatCommand.FORCE :
                    curLine += cmd.getNumCommands();
                    curColumn = curIndent + 1;
                    break;
                case FormatCommand.INDENT :
                    curIndent += indentAmt * cmd.getNumCommands();
                    break;
                case FormatCommand.OUTDENT :
                    if ( curIndent >= indentAmt )
                        curIndent -= indentAmt * cmd.getNumCommands();
                    break;
                case FormatCommand.SPACE :
                    curColumn += cmd.getNumCommands();
                    break;
                default :
                    throw new TreeFormatterException(
                        "Invalid value in command queue.");
            }
        }

        cmdQueue.removeAllElements();

        //
        // Handle all special tokens preceding this NodeToken
        //
        if ( n.numSpecials() > 0 )
            for ( Enumeration<NodeToken> e = n.specialTokens.elements();
                  e.hasMoreElements(); ) {
                NodeToken special = e.nextElement();

                //
                // -Place the token.
                // -Move cursor to next line after the special token.
                // -Don't update curColumn--want to keep current indent level.
                //
                placeToken(special, curLine, curColumn);
                curLine = special.endLine + 1;
            }

        placeToken(n, curLine, curColumn);
        curLine = n.endLine;
        curColumn = n.endColumn;
    }

    /**
     * Inserts token location (beginLine, beginColumn, endLine, endColumn)
     * information into the NodeToken.  Takes into account line-wrap.
     * Does not update curLine and curColumn.
     */
    private void placeToken(NodeToken n, int line, int column) {
        int length = n.tokenImage.length();

        //
        // Find beginning of token.  Only line-wrap for single-line tokens
        //
        if ( !lineWrap || n.tokenImage.indexOf('\n') != -1 ||
             column + length <= wrapWidth )
            n.beginColumn = column;
        else {
            ++line;
            column = curIndent + indentAmt + 1;
            n.beginColumn = column;
        }

        n.beginLine = line;

        //
        // Find end of token; don't count \n if it's the last character
        //
        for ( int i = 0; i < length; ++i ) {
            if ( n.tokenImage.charAt(i) == '\n' && i < length - 1 ) {
                ++line;
                column = 1;
            }
            else
                ++column;
        }

        n.endLine = line;
        n.endColumn = column;
    }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public void visit(Goal n) {
        n.f0.accept(this);
        add(space());
        if ( n.f1.present() ) {
            processList(n.f1, force());
        }
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> "public"
     * f4 -> "static"
     * f5 -> "void"
     * f6 -> "main"
     * f7 -> "("
     * f8 -> "String"
     * f9 -> "["
     * f10 -> "]"
     * f11 -> Identifier()
     * f12 -> ")"
     * f13 -> "{"
     * f14 -> "new"
     * f15 -> Identifier()
     * f16 -> "("
     * f17 -> ")"
     * f18 -> "."
     * f19 -> Identifier()
     * f20 -> "("
     * f21 -> ( ExpressionList() )?
     * f22 -> ")"
     * f23 -> ";"
     * f24 -> "}"
     * f25 -> "}"
     */
    public void visit(MainClass n) {
        add(space());
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(force());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
        n.f5.accept(this);
        add(space());
        n.f6.accept(this);
        add(space());
        n.f7.accept(this);
        add(space());
        n.f8.accept(this);
        add(space());
        n.f9.accept(this);
        add(space());
        n.f10.accept(this);
        add(space());
        n.f11.accept(this);
        add(space());
        n.f12.accept(this);
        add(space());
        n.f13.accept(this);
        add(force());
        n.f14.accept(this);
        add(space());
        n.f15.accept(this);
        add(space());
        n.f16.accept(this);
        add(space());
        n.f17.accept(this);
        add(space());
        n.f18.accept(this);
        add(space());
        n.f19.accept(this);
        add(space());
        n.f20.accept(this);
        add(space());
        if ( n.f21.present() ) {
            n.f21.accept(this);
        add(space());
        }
        n.f22.accept(this);
        add(space());
        n.f23.accept(this);
        add(space());
        n.f24.accept(this);
        add(space());
        n.f25.accept(this);
        add(space());
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public void visit(TypeDeclaration n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public void visit(ClassDeclaration n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        if ( n.f3.present() ) {
            processList(n.f3, space(2));
        }
        if ( n.f4.present() ) {
            processList(n.f4, space(2));
        }
        n.f5.accept(this);
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "extends"
     * f3 -> Identifier()
     * f4 -> "{"
     * f5 -> ( VarDeclaration() )*
     * f6 -> ( MethodDeclaration() )*
     * f7 -> "}"
     */
    public void visit(ClassExtendsDeclaration n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
        if ( n.f5.present() ) {
            processList(n.f5);
        }
        if ( n.f6.present() ) {
            processList(n.f6);
        }
        n.f7.accept(this);
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public void visit(VarDeclaration n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
    }

    /**
     * f0 -> "public"
     * f1 -> "void"
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "}"
     */
    public void visit(MethodDeclaration n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        if ( n.f4.present() ) {
            n.f4.accept(this);
        add(space());
        }
        n.f5.accept(this);
        add(space());
        n.f6.accept(this);
        add(space());
        if ( n.f7.present() ) {
            processList(n.f7, space());
        }
        if ( n.f8.present() ) {
            processList(n.f8, space());
        }
        n.f9.accept(this);
        add(space());
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public void visit(FormalParameterList n) {
        n.f0.accept(this);
        if ( n.f1.present() ) {
            processList(n.f1, space());
        }
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public void visit(FormalParameter n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public void visit(FormalParameterRest n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public void visit(Type n) {
        n.f0.accept(this);
        add(space());
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public void visit(ArrayType n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
    }

    /**
     * f0 -> "boolean"
     */
    public void visit(BooleanType n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "int"
     */
    public void visit(IntegerType n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> Block()
     *       | AssignmentStatement()
     *       | ArrayAssignmentStatement()
     *       | IfStatement()
     *       | WhileStatement()
     *       | PrintStatement()
     *       | MessageSendStatement()
     */
    public void visit(Statement n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public void visit(Block n) {
        n.f0.accept(this);
        add(space());
        if ( n.f1.present() ) {
            processList(n.f1, space());
        }
        n.f2.accept(this);
        add(space());
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public void visit(AssignmentStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
    }

    /**
     * f0 -> Identifier()
     * f1 -> "["
     * f2 -> Expression()
     * f3 -> "]"
     * f4 -> "="
     * f5 -> Expression()
     * f6 -> ";"
     */
    public void visit(ArrayAssignmentStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
        n.f5.accept(this);
        add(space());
        n.f6.accept(this);
        add(space());
    }

    /**
     * f0 -> "if"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     * f5 -> "else"
     * f6 -> Statement()
     */
    public void visit(IfStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
        n.f5.accept(this);
        add(space());
        n.f6.accept(this);
        add(space());
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public void visit(WhileStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public void visit(PrintStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
        add(space());
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    public void visit(MessageSendStatement n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        if ( n.f4.present() ) {
            n.f4.accept(this);
        add(space());
        }
        n.f5.accept(this);
        add(space());
        n.f6.accept(this);
        add(space());
    }

    /**
     * f0 -> AndExpression()
     *       | CompareExpression()
     *       | PlusExpression()
     *       | MinusExpression()
     *       | TimesExpression()
     *       | ArrayLookup()
     *       | PrimaryExpression()
     */
    public void visit(Expression n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public void visit(AndExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public void visit(CompareExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public void visit(PlusExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public void visit(MinusExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public void visit(TimesExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public void visit(ArrayLookup n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public void visit(ExpressionList n) {
        n.f0.accept(this);
        add(space());
        if ( n.f1.present() ) {
            processList(n.f1, space());
        }
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public void visit(ExpressionRest n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | VarRef()
     *       | ThisExpression()
     *       | ArrayAllocationExpression()
     *       | AllocationExpression()
     *       | NotExpression()
     *       | BracketExpression()
     */
    public void visit(PrimaryExpression n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public void visit(IntegerLiteral n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "true"
     */
    public void visit(TrueLiteral n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "false"
     */
    public void visit(FalseLiteral n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public void visit(Identifier n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "this"
     */
    public void visit(ThisExpression n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public void visit(ArrayAllocationExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
        add(space());
        n.f4.accept(this);
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public void visit(AllocationExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
        add(space());
        n.f3.accept(this);
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public void visit(NotExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public void visit(BracketExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public void visit(VarRef n) {
        n.f0.accept(this);
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public void visit(DotExpression n) {
        n.f0.accept(this);
        add(space());
        n.f1.accept(this);
        add(space());
        n.f2.accept(this);
    }

}

class FormatCommand {
    public static final int FORCE = 0;
    public static final int INDENT = 1;
    public static final int OUTDENT = 2;
    public static final int SPACE = 3;

    private int command;
    private int numCommands;

    FormatCommand(int command, int numCommands) {
        this.command = command;
        this.numCommands = numCommands;
    }

    public int getCommand()             { return command; }
    public int getNumCommands()         { return numCommands; }
    public void setCommand(int i)       { command = i; }
    public void setNumCommands(int i)   { numCommands = i; }
}

class TreeFormatterException extends RuntimeException {
    TreeFormatterException()         { super(); }
    TreeFormatterException(String s) { super(s); }
}
