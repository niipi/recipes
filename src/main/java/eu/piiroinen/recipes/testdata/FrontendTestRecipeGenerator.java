package eu.piiroinen.recipes.testdata;

import eu.piiroinen.recipes.model.Ingredient;
import eu.piiroinen.recipes.model.Instruction;
import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.model.RecipeCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class FrontendTestRecipeGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(FrontendTestRecipeGenerator.class);

    private FrontendTestCategoryGenerator categoryGenerator = new FrontendTestCategoryGenerator();
    private List<RecipeCategory> categories = categoryGenerator.generateTestRecipeCategoryList();


    private ArrayList<Ingredient> ingredientsForKasperinKanaviillokki() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient kananrinta = new Ingredient("800g", "kananrintafile");
        ingredients.add(kananrinta);
        Ingredient sipuli = new Ingredient("1", "iso sipuli");
        ingredients.add(sipuli);
        Ingredient valkosipuli = new Ingredient("2", "valkosipulin kynttä");
        ingredients.add(valkosipuli);
        Ingredient oljy = new Ingredient("2 rkl", "öljyä");
        ingredients.add(oljy);
        Ingredient suola = new Ingredient("2 tl", "suolaa");
        ingredients.add(suola);
        Ingredient mustapippuri = new Ingredient("1 tl", "mustapippuria");
        ingredients.add(mustapippuri);
        Ingredient laakerinlehti = new Ingredient("2", "laakerinlehteä");
        ingredients.add(laakerinlehti);
        Ingredient timjami = new Ingredient("1 rkl", "timjamia");
        ingredients.add(timjami);
        Ingredient valkoviini = new Ingredient("1 dl", "valkoviiniä (vapaaehtoinen)");
        ingredients.add(valkoviini);
        Ingredient kanaliemi = new Ingredient("5 dl", "kanalientä (kana-fondi + vesi tai valmis kanaliemi)");
        ingredients.add(kanaliemi);
        Ingredient ruokakerma = new Ingredient("3 dl", "ruokakermaa");
        ingredients.add(ruokakerma);
        Ingredient vehnajauho = new Ingredient("2 rkl", "vehnäjauhoja (tarvittaessa)");
        ingredients.add(vehnajauho);
        Ingredient yrtit = new Ingredient("", "Tuoreita yrttejä koristeluun (esim. persiljaa)");
        ingredients.add(yrtit);

        return ingredients;
    }

    private ArrayList<Instruction> generateInstructionsForTestRecipes(String instructionString) {
        ArrayList<Instruction> instructions = new ArrayList<>();

        Pattern ordinalpattern = Pattern.compile("\\d+\\W\\s");
        CharSequence originalStringAsCharSequence = instructionString.subSequence(0, instructionString.length()-1);

        String[] parts = ordinalpattern.split(originalStringAsCharSequence);

        for (int i = 0; i < parts.length; i++) {
            Matcher matcher = ordinalpattern.matcher(parts[i]);
            if (matcher.matches()) {
                int ordinal = Integer.parseInt(String.valueOf(parts[i].charAt(0)));
                Instruction instruction = new Instruction(ordinal, parts[i+1]);
                instructions.add(instruction);
                i++;
            }
        }

        return instructions;
    }

    private Recipe kasperinKanaviillokki() {
        RecipeCategory chicken = categories.get(0);
        ArrayList<RecipeCategory> categoriesForKasperinKanaviillokki = new ArrayList<>();
        categoriesForKasperinKanaviillokki.add(chicken);
        ArrayList<Ingredient> ingredients = ingredientsForKasperinKanaviillokki();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1. " +
                "    Leikkaa kananrintafile pienemmiksi paloiksi. Kuori ja silppua sipuli sekä valkosipuli.\n" +
                "2. " +
                "    Kuumenna öljy pannulla ja ruskista kananpalat. Lisää sipuli ja valkosipuli, ja kuullota kunnes sipuli on pehmeä.\n" +
                "3. " +
                "    Mausta ruskistetut kananpalat suolalla, mustapippurilla, laakerinlehdillä ja timjamilla. Jos käytät valkoviiniä, lisää se nyt ja anna sen kiehua hetken aikaa.\n" +
                "4. " +
                "    Lisää panulle kanaliemi ja anna hautua miedolla lämmöllä noin 20 minuuttia.\n" +
                "5. " +
                "    Sekoita ruokakerma ja vehnäjauhot keskenään, lisää seos pannulle ja sekoita hyvin. Anna kiehua hiljalleen noin 10 minuuttia, kunnes kastike sakenee.\n" +
                "6. " +
                "    Tarkista maku ja lisää tarvittaessa mausteita. Koristele tuoreilla yrteillä juuri ennen tarjoilua.");

        return new Recipe("Kasperin kanaviillokki", ingredients, instructions, categoriesForKasperinKanaviillokki, "https://www.kariniemen.fi/globalassets/emmi/hkscan-finland/kariniemen/kariniemen-kotisivut/kariniemen.fi-reseptikuvat/katselukopiot-kananpojan-viillokki-d4s2852-edit.jpg");
    }

    public List<Recipe> generateTestRecipeListing() {
        ArrayList<Recipe> testRecipes = new ArrayList<>();

        testRecipes.add(kasperinKanaviillokki());

        return testRecipes;
    }
}
