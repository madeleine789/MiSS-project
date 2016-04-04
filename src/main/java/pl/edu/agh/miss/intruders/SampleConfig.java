package pl.edu.agh.miss.intruders;

import pl.edu.agh.miss.intruders.api.Config;
import pl.edu.agh.miss.intruders.api.Robot;

public class SampleConfig implements Config {

	@Override
	public int getNewProbability(int currentProbability, Robot robot) {
		return currentProbability/10+1;
	}

}
