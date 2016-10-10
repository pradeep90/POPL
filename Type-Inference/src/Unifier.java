import java.util.HashSet;
import java.util.Set;

public class Unifier {
    public boolean failure = false;
    public TypeEnvironment unification = new TypeEnvironment();

    public Set<TypeEquation> equationSet;

    public Unifier(Set<TypeEquation> equationSet) {
        this.equationSet = new HashSet<TypeEquation>(equationSet);
    }

    public TypeEquation removeFromSet(Set<TypeEquation> equationSet){
        TypeEquation currTypeEquation = null;
        if (!equationSet.isEmpty()){
            currTypeEquation = equationSet.iterator().next();
            equationSet.remove(currTypeEquation);
        }
        return currTypeEquation;
    }

    /**
     * @return true iff you can unify the equations in equationSet.
     */
    public boolean unify(){
        while(!equationSet.isEmpty() && !failure){
            TypeEquation currEquation = removeFromSet(equationSet).substitute(unification);
            Type s = currEquation.type1;
            Type t = currEquation.type2;

            new HandleEquationVisitor(this).runMultiMethod(s, t);
        }
        return !failure;
    }
}
