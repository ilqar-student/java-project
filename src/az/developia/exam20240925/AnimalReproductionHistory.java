package az.developia.exam20240925;

public record AnimalReproductionHistory<T extends Pet<?>>(T pet, int reproduced) {
}
