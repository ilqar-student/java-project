package az.developia.exam20240925;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// Note: Pet names are from Google search.

		// Create objects for each [locally] known Pet 
		Cat catDaisy = new Cat("Daisy", Gender.FAMALE);
		Cat catPoppy = new Cat("Poppy", Gender.MALE);
		Cat catBella = new Cat("Misty", Gender.FAMALE);
		Dog dogBailey = new Dog("Bailey", Gender.MALE);
		Dog dogBella = new Dog("Bella", Gender.FAMALE);

		// Create a collection of animals
		HashSet<Animal> animals = new HashSet<Animal>();
		animals.add(catDaisy);
		animals.add(catPoppy);
		animals.add(catBella);
		animals.add(dogBailey);
		animals.add(dogBella);

		// Try to change the nickname of a cat
		changeNickname(catDaisy, "_Daisy");

		// Actions of the Cat
		catDaisy.eat();
		catDaisy.reproduce(catBella);
		catDaisy.reproduce(catPoppy);
		catDaisy.tellStory();

		// Actions of the Dog
		dogBailey.eat();
		dogBailey.sleep();
		dogBailey.wake();
		dogBailey.reproduce(dogBella);
		dogBailey.tellStory();

		System.out.println("\nPets info:");
		System.out.println(catDaisy);
		System.out.println(dogBailey);

		System.out.println("\nPets known for their LOYALTY:");
		printLoyalPets(animals, 3);
	}

	static void changeNickname(Pet<?> pet, String newNickname) {
		// Change nickname
		try {
			pet.setNickname(newNickname);
		}
		// Handle nickname related exception without interrupting the program
		catch (NicknameException exception) {
			System.out.println("Nickname exception is thrown when changing the nickname of '" + pet.getNickname() + "' ");
			System.out.println("Message:\n\t" + exception + "\n");
			System.out.println("The exception was handled this way.");
			System.out.println("Continue ...\n");
		}
	}

	static void printLoyalPets(HashSet<Animal> animals, int indent) {
		for (Animal animal : animals) {
			if (animal instanceof QualityLoyalty) {
				System.out.println(animal.toString().indent(indent));
			}
		}
	}

}
