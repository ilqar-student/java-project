package az.developia.exam20240925;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Pet<TPet extends Pet<?>> implements Animal {
	private String nickname;
	private final String NICKNAME_VALIDATION_PATTERN = "[A-Za-z]+";
	private final ArrayList<AnimalReproductionHistory<TPet>> reproductionHistory;
	private final ArrayList<AnimalName> nicknameHistory;
	private final Gender gender;
	private boolean asleep;

	public Pet(String nickname, Gender gender) {
		this.nickname = nickname;
		this.gender = gender;
		reproductionHistory = new ArrayList<AnimalReproductionHistory<TPet>>();
		nicknameHistory = new ArrayList<AnimalName>();
	}

	public void setNickname(String nickname) throws NicknameException {
		boolean hasInvalidCharacters = nickname.matches(NICKNAME_VALIDATION_PATTERN);
		if (!hasInvalidCharacters) {
			throw new NicknameException("Input: " + nickname + "\n\tValid nickname pattern: " + NICKNAME_VALIDATION_PATTERN);
		}
		AnimalName animalName = new AnimalName(this.nickname, nickname);
		nicknameHistory.add(animalName);
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public void sleep() {
		this.asleep = true;
	}

	@Override
	public void wake() {
		this.asleep = false;
	}

	public boolean isAsleep() {
		return asleep;
	}

	public abstract void reproduce(TPet with);

	protected void reproduce(TPet withOtherAnimal, int min, int max) {
		int reproducedNumber = new Random().nextInt(min, max);
		AnimalReproductionHistory<TPet> story = new AnimalReproductionHistory<TPet>(withOtherAnimal, reproducedNumber);
		reproductionHistory.add(story);
	}

	public List<AnimalReproductionHistory<TPet>> history() {
		return reproductionHistory;
	}

	public void tellStory() {
		System.out.println("Mate History of " + getNickname());
		for (AnimalReproductionHistory<TPet> animalHistory : history()) {
			System.out.println("\t"
					+ animalHistory.pet().getGender() + " "
					+ "Partner: " + animalHistory.pet().getNickname() + ", Number of animals produced: " + animalHistory.reproduced());
		}
		System.out.println("LIFE CONTINUES ... \n");
	}
	
	@Override
	public String toString() {
		return "Nickname: " + nickname + ", Gender: " + gender;
	}

	public boolean equals(TPet otherPet) {
		// Check for basic equality [up-casting]
		if (!equals(otherPet)) {
			return false;
		}
		// No down-casting is needed.
		// No other checking is required 
		// until TPet specific property will be necessary to be checked.
		return true;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (otherObject == this) {
			return true;
		}
		if (getClass() == otherObject.getClass()) {
			return true;
		}
		return false;
	}

}
