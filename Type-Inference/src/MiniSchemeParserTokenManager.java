/* Generated By:JavaCC: Do not edit this line. MiniSchemeParserTokenManager.java */
import syntaxtree.*;
import java.util.Vector;

/** Token Manager. */
public class MiniSchemeParserTokenManager implements MiniSchemeParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x5e000L) != 0L)
         {
            jjmatchedKind = 20;
            return 4;
         }
         return -1;
      case 1:
         if ((active0 & 0x2000L) != 0L)
            return 4;
         if ((active0 & 0x5c000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 1;
            return 4;
         }
         return -1;
      case 2:
         if ((active0 & 0x44000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 20;
               jjmatchedPos = 2;
            }
            return 4;
         }
         if ((active0 & 0x18000L) != 0L)
            return 4;
         return -1;
      case 3:
         if ((active0 & 0x14000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 3;
            return 4;
         }
         return -1;
      case 4:
         if ((active0 & 0x14000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 4;
            return 4;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 35:
         return jjMoveStringLiteralDfa1_0(0x1800L);
      case 40:
         return jjStopAtPos(0, 9);
      case 41:
         return jjStopAtPos(0, 10);
      case 43:
         return jjStopAtPos(0, 17);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x1c000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x58000L);
      case 102:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(1, 12);
         else if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(1, 13, 4);
         break;
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(1, 11);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 116:
         if ((active0 & 0x8000L) != 0L)
         {
            jjmatchedKind = 15;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x50000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 33:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(3, 18);
         break;
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 4);
         break;
      case 99:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(5, 16, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec3 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec4 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec5 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec6 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec7 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec8 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 24;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAdd(1);
                  }
                  else if (curChar == 47)
                     jjAddStates(0, 2);
                  else if (curChar == 36)
                  {
                     if (kind > 20)
                        kind = 20;
                     jjCheckNAdd(4);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 19)
                        kind = 19;
                  }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar == 48 && kind > 19)
                     kind = 19;
                  break;
               case 3:
                  if (curChar != 36)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(4);
                  break;
               case 5:
                  if (curChar == 47)
                     jjAddStates(0, 2);
                  break;
               case 6:
                  if (curChar == 47)
                     jjCheckNAddStates(3, 5);
                  break;
               case 7:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 8:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 9:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 10:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 12:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 13:
                  if (curChar == 42)
                     jjCheckNAddStates(6, 8);
                  break;
               case 14:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 15:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 16:
                  if (curChar == 47 && kind > 7)
                     kind = 7;
                  break;
               case 17:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 18:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 19:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 20:
                  if (curChar == 42)
                     jjCheckNAddStates(9, 11);
                  break;
               case 21:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(22, 20);
                  break;
               case 22:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(22, 20);
                  break;
               case 23:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 4:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(4);
                  break;
               case 7:
                  jjAddStates(3, 5);
                  break;
               case 12:
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 14:
               case 15:
                  jjCheckNAddTwoStates(15, 13);
                  break;
               case 19:
                  jjCheckNAddTwoStates(19, 20);
                  break;
               case 21:
               case 22:
                  jjCheckNAddTwoStates(22, 20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 4:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(4);
                  break;
               case 7:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(3, 5);
                  break;
               case 12:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 14:
               case 15:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 19:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 21:
               case 22:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(22, 20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 24 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   6, 17, 18, 7, 8, 10, 13, 14, 16, 20, 21, 23, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec3[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec6[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         if ((jjbitVec7[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\50", "\51", "\43\164", 
"\43\146", "\151\146", "\154\141\155\142\144\141", "\154\145\164", 
"\154\145\164\162\145\143", "\53", "\163\145\164\41", null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1ffe01L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
static final long[] jjtoSpecial = {
   0x1c0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[24];
private final int[] jjstateSet = new int[48];
protected char curChar;
/** Constructor. */
public MiniSchemeParserTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public MiniSchemeParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 24; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
