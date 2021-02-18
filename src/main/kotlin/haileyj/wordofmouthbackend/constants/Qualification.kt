package haileyj.wordofmouthbackend.constants

enum class Qualification(var qualification: String, var description: String, var categoryRestrictions: List<Category> = emptyList()) {
    ANIMAL_FIRST_INGREDIENT(
            "Meat, poultry, or seafood as first ingredient",
            "Meat, poultry, or seafood as first ingredient",
            listOf(Category.PETS)
    ),
    BIO_BASED("Bio-Based", "Bio-Based"),
    BIODEGRADABLE("Biodegradable", "Biodegradable"),
    CRUELTY_FREE("Cruelty Free", "Cruelty Free"),
    DYE_FREE("Dye Free", "Dye Free"),
    FAIR_TRADE("Fair Trade", "Fair Trade"),
    FORMULATED_WITHOUT_PARABENS("Formulated without Parabens", "Formulated without Parabens"),
    FORMULATED_WITHOUT_PTHALATES("Formulated without Pthalates", "Formulated without Pthalates"),
    FORMULATED_WITHOUT_SULFATES("Formulated without Sulfates", "Formulated without Sulfates"),
    GLUTEN_FREE("Gluten free", "Gluten free"),
    GRAIN_FREE("Grain Free",  "Grain Free", listOf(Category.PETS)),
    NO_ANIMAL_BY_PRODUCTS(
            "No animal by-products",
            "No animal by-products",
            listOf(Category.PETS)
    ),
    NO_ADDED_FRAGRANCE("No Added Fragrance", "No Added Fragrance"),
    NO_ARTIFICIALS("No Artificial Flavors, Colors, or Preservatives", "No Artificial Flavors, Colors, or Preservatives"),
    NO_SYNTHETIC_FRAGRANCE("No Synthetic Fragrance", "No Synthetic Fragrance"),
    NON_GMO("Non-GMO", "Non-GMO"),
    NON_TOXIC("Non Toxic", "Non Toxic"),
    ORGANIC("Organic", "Organic"),
    ORGANIC_COTTON("Made with Organic Cotton", "Made with Organic Cotton"),
    PREBIOTIC_PROBIOTIC("Prebiotic or Probiotic", "Prebiotic or Probiotic"),
    PLANT_BASED("Plant-Based", "Plant-Based"),
    SUSTAINABLE_SEAFOOD("Sustainable Seafood", "Sustainable Seafood"),
    VEGAN("Vegan", "Vegan"),
    VEGETARIAN("Vegetarian", "Vegetarian"),
    WHOLE_GRAIN("Whole Grain", "Whole Grain")
}