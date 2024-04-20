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

    private ArrayList<Ingredient> ingredientsForNiinanHernari() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient hernekeitto = new Ingredient("1 tölkki", "purkkihernekeittoa");
        ingredients.add(hernekeitto);
        Ingredient vesi = new Ingredient("jonkin verran", "vettä");
        ingredients.add(vesi);

        return ingredients;
    }

    private ArrayList<Ingredient> ingredientsForTomminHernari() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient herneet = new Ingredient("1 kg", "kuivattuja herneitä");
        ingredients.add(herneet);
        Ingredient sipuli = new Ingredient("3", "isoa sipulia");
        ingredients.add(sipuli);
        Ingredient valkosipuli = new Ingredient("6", "valkosipulin kynttä");
        ingredients.add(valkosipuli);
        Ingredient laakerinlehti = new Ingredient("6", "laakerinlehtiä");
        ingredients.add(laakerinlehti);
        Ingredient maustepippuri = new Ingredient("2 tl", "maustepippuria");
        ingredients.add(maustepippuri);
        Ingredient suola = new Ingredient("3 rkl", "suolaa");
        ingredients.add(suola);
        Ingredient siankaula = new Ingredient("2 kg", "siankaulaa");
        ingredients.add(siankaula);
        Ingredient vesi = new Ingredient("5 l", "vettä");
        ingredients.add(vesi);

        return ingredients;
    }

    private ArrayList<Ingredient> ingredientsForKatriinanKasvispasta() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient spagetti = new Ingredient("500 g", "täysjyväspagettia");
        ingredients.add(spagetti);
        Ingredient valkosipuli = new Ingredient("4", "valkosipulin kynttä");
        ingredients.add(valkosipuli);
        Ingredient oliiviöljy = new Ingredient("4 rkl", "oliiviöljyä");
        ingredients.add(oliiviöljy);
        Ingredient kesäkurpitsa = new Ingredient("2", "kesäkurpitsaa");
        ingredients.add(kesäkurpitsa);
        Ingredient porkkana = new Ingredient("4", "porkkanaa");
        ingredients.add(porkkana);
        Ingredient herkkusieni = new Ingredient("500 g", "herkkusieniä");
        ingredients.add(herkkusieni);
        Ingredient valkoviini = new Ingredient("2 dl", "valkoviiniä (vapaaehtoinen)");
        ingredients.add(valkoviini);
        Ingredient ruokakerma = new Ingredient("2 dl", "ruokakermaa");
        ingredients.add(ruokakerma);
        Ingredient suola = new Ingredient("1 tl", "suolaa");
        ingredients.add(suola);
        Ingredient mustapippuri = new Ingredient("1 tl", "mustapippuria");
        ingredients.add(mustapippuri);
        Ingredient tuore_basilika = new Ingredient("", "tuoretta basilikaa koristeluun");
        ingredients.add(tuore_basilika);

        return ingredients;
    }

    private ArrayList<Ingredient> ingredientsForHannaRiikanHatsapuri() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient vehnäjauho = new Ingredient("500 g", "vehnäjauhoja");
        ingredients.add(vehnäjauho);
        Ingredient suola = new Ingredient("1 tl", "suolaa");
        ingredients.add(suola);
        Ingredient vesi = new Ingredient("2,5 dl", "lämmintä vettä");
        ingredients.add(vesi);
        Ingredient juusto = new Ingredient("400 g", "juustoraastetta (esim. mozzarellaa)");
        ingredients.add(juusto);
        Ingredient muna = new Ingredient("2", "munaa");
        ingredients.add(muna);
        Ingredient voi = new Ingredient("50 g", "voita");
        ingredients.add(voi);

        return ingredients;
    }

    private ArrayList<Ingredient> ingredientsForSinituulinSuppilovahveropiiras() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient piirakkapohja = new Ingredient("1", "valmis ruispiirakkapohja");
        ingredients.add(piirakkapohja);
        Ingredient suppilovahverot = new Ingredient("500 g", "suppilovahveroita");
        ingredients.add(suppilovahverot);
        Ingredient valkosipuli = new Ingredient("2", "valkosipulin kynttä");
        ingredients.add(valkosipuli);
        Ingredient oliiviöljy = new Ingredient("2 rkl", "oliiviöljyä");
        ingredients.add(oliiviöljy);
        Ingredient kerma = new Ingredient("2 dl", "ruokakermaa");
        ingredients.add(kerma);
        Ingredient muna = new Ingredient("3", "munaa");
        ingredients.add(muna);
        Ingredient juusto = new Ingredient("200 g", "emmental-juustoraastetta");
        ingredients.add(juusto);
        Ingredient suola = new Ingredient("1/2 tl", "suolaa");
        ingredients.add(suola);
        Ingredient mustapippuri = new Ingredient("1/2 tl", "mustapippuria");
        ingredients.add(mustapippuri);

        return ingredients;
    }

    private ArrayList<Instruction> generateInstructionsForTestRecipes(String instructionString) {
        ArrayList<Instruction> instructions = new ArrayList<>();

        Pattern ordinalpattern = Pattern.compile("(\\d+\\.\\s)");
        CharSequence originalStringAsCharSequence = instructionString.subSequence(0, instructionString.length()-1);

        String[] parts = ordinalpattern.split(originalStringAsCharSequence);

        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                Instruction instruction = new Instruction(i, parts[i]);
                instructions.add(instruction);
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
                "Leikkaa kananrintafile pienemmiksi paloiksi. Kuori ja silppua sipuli sekä valkosipuli.\n" +
                "2. " +
                "Kuumenna öljy pannulla ja ruskista kananpalat. Lisää sipuli ja valkosipuli, ja kuullota kunnes sipuli on pehmeä.\n" +
                "3. " +
                "Mausta ruskistetut kananpalat suolalla, mustapippurilla, laakerinlehdillä ja timjamilla. Jos käytät valkoviiniä, lisää se nyt ja anna sen kiehua hetken aikaa.\n" +
                "4. " +
                "Lisää panulle kanaliemi ja anna hautua miedolla lämmöllä noin 20 minuuttia.\n" +
                "5. " +
                "Sekoita ruokakerma ja vehnäjauhot keskenään, lisää seos pannulle ja sekoita hyvin. Anna kiehua hiljalleen noin 10 minuuttia, kunnes kastike sakenee.\n" +
                "6. " +
                "Tarkista maku ja lisää tarvittaessa mausteita. Koristele tuoreilla yrteillä juuri ennen tarjoilua.");

        return new Recipe("Kasperin kanaviillokki", ingredients, instructions, categoriesForKasperinKanaviillokki, "https://www.kariniemen.fi/globalassets/emmi/hkscan-finland/kariniemen/kariniemen-kotisivut/kariniemen.fi-reseptikuvat/katselukopiot-kananpojan-viillokki-d4s2852-edit.jpg");
    }

    private Recipe niinanHernari() {
        RecipeCategory veggie = categories.get(3);
        ArrayList<RecipeCategory> categoriesForNiinanHernari = new ArrayList<>();
        categoriesForNiinanHernari.add(veggie);
        ArrayList<Ingredient> ingredients = ingredientsForNiinanHernari();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1. Avaa hernekeittotölkki.\n2. Lisää kattilaan hernekeitto" +
                " ja jonkin verran vettä.\n" +
                "3. Keitä jonkin aikaa ja tarjoile.\n");

        return new Recipe("Niinan hernekeitto", ingredients, instructions, categoriesForNiinanHernari, "https://www.kivikylan.fi/clients/kivikyla/mellow_internal/imagefolder/fi//generated/2232kivikylan_hernekeitto_2022_small500x500s.png");
    }

    private Recipe tomminHernari() {
        RecipeCategory meat = categories.get(1);
        ArrayList<RecipeCategory> categoriesForTomminHernari = new ArrayList<>();
        categoriesForTomminHernari.add(meat);
        ArrayList<Ingredient> ingredients = ingredientsForTomminHernari();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1." +
                "    Laita herneet likoamaan runsaaseen kylmään veteen vähintään 8 tunniksi.\n" +
                "2." +
                "    Kuori ja hienonna sipulit ja valkosipulit.\n" +
                "3." +
                "    Ota suuri kattila ja laita liotetut herneet, hienonnetut sipulit, valkosipulit, laakerinlehdet, maustepippurit ja siankaula kattilaan.\n" +
                "4." +
                "    Lisää vettä niin, että ainekset peittyvät kunnolla.\n" +
                "5." +
                "    Anna keiton kiehua hiljalleen noin 2-3 tuntia, kunnes liha on kypsää.\n" +
                "6." +
                "    Poista liha keitosta, leikkaa se pieniksi paloiksi ja laita takaisin keittoon.\n" +
                "7." +
                "    Lisää suola ja anna keiton kiehua vielä 15-30 minuuttia. Tarkista maku.\n" +
                "8." +
                "    Hernekeitto on valmista tarjoiltavaksi. Se maistuu parhaalta esimerkiksi pannukakun kanssa.\n");

        return new Recipe("Tommin perinteinen hernekeitto", ingredients, instructions, categoriesForTomminHernari, "https://images.ctfassets.net/0yf82hjfqumz/1CabpO9OYpM7g0JNXAQHDb/2f4b159277755b21192828cc3c509632/hernekeitto_netti.jpg");
    }

    private Recipe katriinanKasvispasta() {
        RecipeCategory veggie = categories.get(3);
        ArrayList<RecipeCategory> categoriesForKatriinanKasvispasta = new ArrayList<>();
        categoriesForKatriinanKasvispasta.add(veggie);
        ArrayList<Ingredient> ingredients = ingredientsForKatriinanKasvispasta();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1." +
                "    Keitä spagetti pakkauksen ohjeiden mukaan. Valuta ja aseta sivuun.\n" +
                "2." +
                "    Kuori ja hienonna valkosipulit. Pese ja pilko kasvikset sopiviksi paloiksi.\n" +
                "3." +
                "    Kuumenna oliiviöljy pannulla ja lisää hienonnettu valkosipuli. Kuullota hetki.\n" +
                "4." +
                "    Lisää pannulle kesäkurpitsa, porkkana ja herkkusienet. Paista kasviksia, kunnes ne ovat pehmenneet.\n" +
                "5." +
                "    Jos käytät valkoviiniä, lisää se nyt ja anna sen kiehua hetken aikaa.\n" +
                "6." +
                "    Sekoita joukkoon ruokakerma. Mausta suolalla ja pippurilla.\n" +
                "7." +
                "    Sekoita valutettu spagetti kastikkeen joukkoon ja kuumenna hetki.\n" +
                "8." +
                "    Lisää tuoretta basilikaa päälle juuri ennen tarjoilua.\n");

        return new Recipe("Katriinan kasvispasta", ingredients, instructions, categoriesForKatriinanKasvispasta, "https://images.ctfassets.net/kt8yvydomzor/1OCYfffVsMC4MgQaS4wqwa/50d429c96be0f9132e0c3c5e2f34b006/Pestopasta_2019.jpg");
    }

    private Recipe hannaRiikanHatsapuri() {
        RecipeCategory veggie = categories.get(3);
        RecipeCategory baking = categories.get(4);
        ArrayList<RecipeCategory> categoriesForHannaRiikanHatsapuri = new ArrayList<>();
        categoriesForHannaRiikanHatsapuri.add(veggie);
        categoriesForHannaRiikanHatsapuri.add(baking);
        ArrayList<Ingredient> ingredients = ingredientsForHannaRiikanHatsapuri();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1." +
                "    Sekoita vehnäjauhot ja suola isossa kulhossa. Lisää lämmin vesi vähitellen ja alusta taikina kunnes se on pehmeää mutta ei tartu käsiin. Anna taikinan levätä n. 15 minuuttia.\n" +
                "2." +
                "    Jaa taikina kahteen osaan. Kauli molemmat osat ohueksi pyöreäksi levyksi.\n" +
                "3." +
                "    Sekoita juustoraaste ja munat kulhossa. Levitä seos toisen taikinalevyn päälle.\n" +
                "4." +
                "    Peitä juustotäyte toisella taikinalevyllä ja nipistä reunat yhteen. Tee muutama reikä piiraan päälle haarukalla.\n" +
                "5." +
                "    Paista 200-asteisessa uunissa noin 20 minuuttia tai kunnes piiras on kauniin ruskea.\n" +
                "6." +
                "    Ota piiras uunista ja voitele se heti voinokareella. Anna hatsapurin levätä hetki ennen tarjoilua.\n");

        return new Recipe("Hanna-Riikan hatsapuri", ingredients, instructions, categoriesForHannaRiikanHatsapuri, "https://assets.meillakotona.fi/w7lrg8grgqb7/3NuPIOm6lDqwucCpAZJYP9/b33abbca4ad98d5dd0327fcfd89f23b5/-Volumes-Hannes-Valokuvat-2019-06-12-MK0619-21_preview__1__DwII1.jpg");
    }

    private Recipe sinituulinSuppilovahveropiiras() {
        RecipeCategory veggie = categories.get(3);
        RecipeCategory baking = categories.get(4);
        ArrayList<RecipeCategory> categoriesForSinituulinSuppilovahveropiiras = new ArrayList<>();
        categoriesForSinituulinSuppilovahveropiiras.add(veggie);
        categoriesForSinituulinSuppilovahveropiiras.add(baking);
        ArrayList<Ingredient> ingredients = ingredientsForSinituulinSuppilovahveropiiras();
        ArrayList<Instruction> instructions = generateInstructionsForTestRecipes("1." +
                "    Laita piirakkapohja piirakkavuokaan ja esipaista sitä 200-asteisessa uunissa n. 10 minuuttia.\n" +
                "2." +
                "    Puhdista suppilovahverot ja paista niitä pannulla, kunnes ylimääräinen neste on haihtunut.\n" +
                "3." +
                "    Lisää hienonnettu valkosipuli ja oliiviöljy pannulle. Paista hetki.\n" +
                "4." +
                "    Sekoita ruokakerma, munat, juustoraaste, suola ja mustapippuri kulhossa. Lisää joukkoon paistetut suppilovahverot ja sekoita hyvin.\n" +
                "5." +
                "    Kaada seos esipaistetun piirakkapohjan päälle.\n" +
                "6." +
                "    Paista 200-asteisessa uunissa noin 30 minuuttia tai kunnes piirakka on kypsä ja kauniin ruskea.\n");

        return new Recipe("Sinituulin suppilovahveropiiras", ingredients, instructions, categoriesForSinituulinSuppilovahveropiiras, "https://kotiliesi.fi/awpo/img/2020/10/ko1714ky_04_preview-1-e1661589646274.jpg?s=b8ddd080e28e16f4e7492356abb3eb2c");
    }

    public List<Recipe> generateTestRecipeListing() {
        ArrayList<Recipe> testRecipes = new ArrayList<>();

        testRecipes.add(hannaRiikanHatsapuri());
        testRecipes.add(katriinanKasvispasta());
        testRecipes.add(kasperinKanaviillokki());
        testRecipes.add(niinanHernari());
        testRecipes.add(tomminHernari());
        testRecipes.add(sinituulinSuppilovahveropiiras());

        return testRecipes;
    }
}
