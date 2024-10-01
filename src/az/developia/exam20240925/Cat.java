package az.developia.exam20240925;

public class Cat extends Pet<Cat> {
	final static int MIN_KITTENS = 1;
	final static int MAX_KITTENS = 9;

	public Cat(String nickname, Gender gender) {
		super(nickname, gender);
	}

	@Override
	public void eat() {
		System.out.println("Cat '" + getNickname() + "' feed then");
		sleep();
	}
	
	@Override
	public void sleep() {
		super.sleep();
		System.out.println("Cat '" + getNickname() + "' fall asleep");
	}

	@Override
	public void wake() {
		super.wake();
		System.out.println("Cat '" + getNickname() + "' wakes up to PLAY ");
	}

	@Override
	public void reproduce(Cat anotherCat) {
		if (isAsleep()) {
			wake();
			System.out.print("and TO NEW ADVENTURES ! ");
		}
		else {
			System.out.print("Time to have some Fun ! ");
		}
		super.reproduce(anotherCat, MIN_KITTENS, MAX_KITTENS);
		System.out.println("Cat '" + getNickname() + "' begins to reproduce with: " + anotherCat.getNickname());
	}

	@Override
	public void tellStory() {
		System.out.println("Mate History of " + getNickname());
		int totalKittens = 0;
		for (AnimalReproductionHistory<Cat> animalHistory : history()) {
			totalKittens += animalHistory.reproduced();
			System.out.println("\t"
					+ animalHistory.pet().getGender() + " "
					+ "Partner: " + animalHistory.pet().getNickname() + ", "
					+ "Number of animals produced: " + animalHistory.reproduced());
		}
		System.out.println("\n\tTotal number of Kittens: " + totalKittens);
		System.out.println("LIFE CONTINUES ... \n");
	}

}
