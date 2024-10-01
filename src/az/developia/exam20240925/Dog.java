package az.developia.exam20240925;

public class Dog extends Pet<Dog> implements QualityLoyalty {
	final static int MIN_PUPPIES = 6;
	final static int MAX_PUPPIES = 8;

	public Dog(String nickname, Gender gender) {
		super(nickname, gender);
	}

	@Override
	public void eat() {
		System.out.println("Dog " + getNickname() + "' feed");
		System.out.println("Dog " + getNickname() + "' PLAY a ball, run and feels happy");
	}

	@Override
	public void sleep() {
		super.sleep();
		System.out.println("Dog '" + getNickname() + "' fall asleep");
	}

	@Override
	public void wake() {
		super.wake();
		System.out.println("Dog '" + getNickname() + "' wakes up to PLAY, be useful and so on");
	}

	@Override
	public void reproduce(Dog anotherDog) {
		if (isAsleep()) {
			wake();
		}
		System.out.println("Dog '" + getNickname() + "' begins to reproduce with: " + anotherDog.getNickname());
		super.reproduce(anotherDog, MIN_PUPPIES, MAX_PUPPIES);
	}

	@Override
	public String toString() {
		StringBuilder lifeStory = new StringBuilder(history().size());
		for (AnimalReproductionHistory<Dog> story : history()) {
			lifeStory.append("Partner: '" + story.pet().getNickname() + "', Puppies: " + story.reproduced());
		}
		return super.toString() + "\n\tLife story: " + lifeStory.toString();
	}
}
