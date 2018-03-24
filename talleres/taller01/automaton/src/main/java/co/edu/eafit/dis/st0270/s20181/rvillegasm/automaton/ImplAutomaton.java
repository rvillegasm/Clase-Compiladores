package co.edu.eafit.dis.st0270.s20181.rvillegasm.automaton;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.lang.Character;
import org.apache.commons.lang3.tuple.Pair;
import co.edu.eafit.dis.st0270.automaton.State;
import co.edu.eafit.dis.st0270.automaton.Automaton;
import co.edu.eafit.dis.st0270.automaton.AutomatonException;

/**
 * Automaton implementation
 * @author Rafael Villegas Michel
 *
 */

  // TODO: check if you can "return this" in cleaning(), getMinimal(), isMinimal()
public class ImplAutomaton extends Automaton
{
    public ImplAutomaton(
                            Set<State> states, 
                            Set<Character> alphabet, 
                            Map<Pair<State,Character>,State> delta, 
                            State initial, 
                            Set<State> finals

                        ) throws AutomatonException, IllegalArgumentException {

        super(states, alphabet, delta, initial, finals);

    }
    
	@Override
	public Automaton cleaning() throws AutomatonException, IllegalArgumentException {
		//Getting the accesible states
		Set<State> accesible = new HashSet<State>();
		for(State q : states) {
			for(Character a : alphabet) {
				if(delta.containsKey(Pair.of(initial, a)) && delta.get(Pair.of(initial, a)).equals(q)) {
					accesible.add(q);
				}
			}
		}
		//Getting the Post-accesible states
		Set<State> postAccesible = new HashSet<State>();
		for(State q : states) {
			for(Character a : alphabet) {
				if(delta.containsKey(Pair.of(q, a)) && finals.contains(delta.get(Pair.of(q, a)))) {
					postAccesible.add(q);
				}
			}
		}
		//Looking for the obsolete states and removing them from the automaton
		for(State q : states) {
			if(!accesible.contains(q) || !postAccesible.contains(q)) {
				for(Character a : alphabet) {
					if(delta.containsKey(Pair.of(q, a))) {
						delta.remove(Pair.of(q, a));
					}
				}
				states.remove(q);
				finals.remove(q);
			}
		}
		return this;
	}

	@Override
	public Automaton getMinimal() throws AutomatonException, IllegalArgumentException {
		return null;
	}

	@Override
	public boolean isClean() {
		//Getting the accesible states
		Set<State> accesible = new HashSet<State>();
		for(State q : states) {
			for(Character a : alphabet) {
				if(delta.containsKey(Pair.of(initial, a)) && delta.get(Pair.of(initial, a)).equals(q)) {
					accesible.add(q);
				}
			}
		}
		//Getting the Post-accesible states
		Set<State> postAccesible = new HashSet<State>();
		for(State q : states) {
			for(Character a : alphabet) {
				if(delta.containsKey(Pair.of(q, a)) && finals.contains(delta.get(Pair.of(q, a)))) {
					postAccesible.add(q);
				}
			}
		}
		//Check if every state is in both sets. If not, it is not clean
		for(State q : states) {
			if(!accesible.contains(q) || !postAccesible.contains(q)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isMinimal() {
		return false;
	}
}
