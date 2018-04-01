package co.edu.eafit.dis.st0270.s20181.rvillegasm.automaton;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
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

public class ImplAutomaton extends Automaton
{
	/** Constructor method */
  public ImplAutomaton(
                          Set<State> states, 
                          Set<Character> alphabet, 
                          Map<Pair<State,Character>,State> delta, 
                          State initial, 
                          Set<State> finals
                      ) throws AutomatonException, IllegalArgumentException {

    super(states, alphabet, delta, initial, finals);

  }
		
	/** Cleans the automaton, removing from it the useless states (non-Accesible and/or non-Post-accesible) */
	@Override
	public Automaton cleaning() throws AutomatonException, IllegalArgumentException {
		//Getting the accesible states
		Set<State> accesible = new HashSet<State>();
		for(State q : this.states) {
			Map<State,Boolean> visited = new HashMap<State,Boolean>();
			if(isAccesible(visited, this.delta, this.alphabet, q, this.initial)) {
				accesible.add(q);
			}
		}
		//Getting the Post-accesible states
		Set<State> postAccesible = new HashSet<State>();
		for(State q : this.states) {
			Map<State,Boolean> visited = new HashMap<State,Boolean>();
			if(isPostAccesible(visited, this.delta, this.alphabet, this.finals, q)) {
				postAccesible.add(q);
			}
		}
		//Looking for the obsolete states and removing them from the automaton
		for(State q : this.states) {
			if(!accesible.contains(q) || !postAccesible.contains(q)) {
				for(Character a : this.alphabet) {
					if(this.delta.containsKey(Pair.of(q, a))) {
						this.delta.remove(Pair.of(q, a));
					}
				}
				this.states.remove(q);
				this.finals.remove(q);
			}
		}
		return this;
	}
	/** Auxiliary function that finds the Accesible states via recursion */
	private boolean isAccesible( 
																Map<State,Boolean> visited, 
																Map<Pair<State,Character>,State> delta, 
																Set<Character> alphabet, 
																State target, 
																State q
															) {
		visited.put(q, true);
		for(Character a : alphabet) {
			if((delta.containsKey(Pair.of(q, a)) && !visited.get(delta.get(Pair.of(q, a)))) && (delta.get(Pair.of(q, a)).equals(target) || isAccesible(visited, delta, alphabet, target, delta.get(Pair.of(q, a))))) {
				return true;
			}
		}
		return false;
	}
	/** Auxiliary function that finds the Post-accesible states via recursion */
	private boolean isPostAccesible( 
																Map<State,Boolean> visited, 
																Map<Pair<State,Character>,State> delta, 
																Set<Character> alphabet, 
																Set<State> finals, 
																State q
															) {
		visited.put(q, true);
		for(Character a : alphabet) {
			if((delta.containsKey(Pair.of(q, a)) && !visited.get(delta.get(Pair.of(q, a)))) && (finals.contains(delta.get(Pair.of(q, a))) || isPostAccesible(visited, delta, alphabet, finals, delta.get(Pair.of(q, a))))) {
				return true;
			}
		}
		return false;
	}

	/** Returns true if the automaton is clean, or false if it is not */
	@Override
	public boolean isClean() {
		//Getting the Accesible states
		Set<State> accesible = new HashSet<State>();
		for(State q : this.states) {
			Map<State,Boolean> visited = new HashMap<State,Boolean>();
			if(isAccesible(visited, this.delta, this.alphabet, q, this.initial)) {
				accesible.add(q);
			}
		}
		//Getting the Post-accesible states
		Set<State> postAccesible = new HashSet<State>();
		for(State q : this.states) {
			Map<State,Boolean> visited = new HashMap<State,Boolean>();
			if(isPostAccesible(visited, this.delta, this.alphabet, this.finals, q)) {
				postAccesible.add(q);
			}
		}
		//Check if every state is in both sets. If not, it is not clean
		for(State q : this.states) {
			if(!accesible.contains(q) || !postAccesible.contains(q)) {
				return false;
			}
		}
		return true;
	}

	/** Unimplmented method */
	@Override
	public Automaton getMinimal() throws AutomatonException, IllegalArgumentException {
		return null;
	}

	/** Unimplmented method */
	@Override
	public boolean isMinimal() {
		return false;
	}
	
}
