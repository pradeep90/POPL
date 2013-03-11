import java.util.Set;

public class Unifier {
    public boolean failure = false;
    TypeEnvironment unification = new TypeEnvironment();

    Set<TypeEquation> allEquations;
    
    public Unifier(Set<TypeEquation> allEquations) {
        this.allEquations = allEquations;
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
    public boolean unify(Set<TypeEquation> equationSet){
        while(!equationSet.isEmpty() && !failure){
            TypeEquation currEquation = removeFromSet(equationSet).substitute(unification);

        }
        return true;
    }

}
