package co.edu.eafit.dis.st0270.s20181.rvillegasm.automaton;

import java.util.Map;
import java.util.Set;
import co.edu.eafit.dis.st0270.automaton.State;
import co.edu.eafit.dis.st0270.automaton.Automaton;
import co.edu.eafit.dis.st0270.automaton.AutomatonException;

/**
 * Automaton implementation
 * @author Rafael Villegas Michel
 *
 */

  // TODO: implement cleaning(), getMinimal(), isCleaning(), isMinimal()
public class ImplAutomaton extends Automaton
{
    public ImplAutomaton(
                            Set<State> states, 
                            Set<java.lang.Character> alphabet, 
                            Map<org.apache.commons.lang3.tuple.Pair<State,java.lang.Character>,State> delta, 
                            State initial, 
                            Set<State> finals

                        ) throws AutomatonException, IllegalArgumentException {

        super(states, alphabet, delta, initial, finals);

    }
    
	@Override
	public Automaton cleaning() throws AutomatonException, IllegalArgumentException {
		return null;
	}

	@Override
	public Automaton getMinimal() throws AutomatonException, IllegalArgumentException {
		return null;
	}

	@Override
	public boolean isClean() {
		return false;
	}

	@Override
	public boolean isMinimal() {
		return false;
	}
}
