package com.example.learnwithfun.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.learnwithfun.R;
import com.example.learnwithfun.repository.MainActivityRepo;
import com.example.learnwithfun.roomDataBase.Database;
import com.example.learnwithfun.roomDataBase.entity.Words;

import java.util.ArrayList;

public class InsertDataViewModel extends AndroidViewModel {
    private MainActivityRepo repository;
    private Words data;
    private ArrayList<Words> dataList;

    public InsertDataViewModel(@NonNull Application application) {
        super(application);
        repository = new MainActivityRepo(application);
    }

    public void insertData() {
        repository.deleteall();
        dataList = new ArrayList<>();

        //Sinhala words
        //============================================================================================================================
        Words sinhalaLetter1Word1 = new Words("Sinhala", "අ", "අම්මා", R.drawable.mother, 1);
        Words sinhalaLetter1Word2 = new Words("Sinhala", "අ", "අහස", R.drawable.sky, 1);
        Words sinhalaLetter1Word3 = new Words("Sinhala", "අ", "අලියා", R.drawable.elephant, 1);
        Words sinhalaLetter2Word1 = new Words("Sinhala", "ආ", "ආච්චි", R.drawable.grand_mother, 1);
        Words sinhalaLetter3Word1 = new Words("Sinhala", "ඇ", "ඇපල්", R.drawable.apple, 1);
        Words sinhalaLetter4Word1 = new Words("Sinhala", "ඈ", "ඈයා", R.drawable.ant_eater, 1);
        Words sinhalaLetter5Word1 = new Words("Sinhala", "ඉ", "ඉදල", R.drawable.garden_broom, 1);
        Words sinhalaLetter5Word2 = new Words("Sinhala", "ඉ", "ඉර", R.drawable.sun, 1);
        Words sinhalaLetter6Word1 = new Words("Sinhala", "ඊ", "ඊතලය", R.drawable.arrow, 1);
        Words sinhalaLetter7Word1 = new Words("Sinhala", "උ", "උදැල්ල", R.drawable.hoe, 1);
        Words sinhalaLetter7Word2 = new Words("Sinhala", "උ", "උණ ගස්", R.drawable.bamboo_tree, 1);
        Words sinhalaLetter8Word1 = new Words("Sinhala", "ඌ", "ඌරා", R.drawable.pig, 1);
        Words sinhalaLetter9Word1 = new Words("Sinhala", "එ", "එළුවා", R.drawable.goat, 1);
        Words sinhalaLetter10Word1 = new Words("Sinhala", "ඒ", "ඒ දණ්ඩ", R.drawable.tree_bridge, 1);
        Words sinhalaLetter11Word1 = new Words("Sinhala", "ඔ", "ඔටුවා", R.drawable.camel, 1);
        Words sinhalaLetter11Word2 = new Words("Sinhala", "ඔ", "ඔරුව", R.drawable.canoe, 1);
        Words sinhalaLetter12Word1 = new Words("Sinhala", "ඕ", "ඕලු", R.drawable.waterlilly, 1);
        Words sinhalaLetter13Word1 = new Words("Sinhala", "ක", "කපුටා", R.drawable.crow, 1);
        Words sinhalaLetter13Word2 = new Words("Sinhala", "ක", "කට", R.drawable.mouth, 1);
        Words sinhalaLetter14Word1 = new Words("Sinhala", "ග", "ගස", R.drawable.tree, 1);
        Words sinhalaLetter14Word2 = new Words("Sinhala", "ග", "ගඟ", R.drawable.river, 1);
        Words sinhalaLetter14Word3 = new Words("Sinhala", "ග", "ගල", R.drawable.rock, 1);
        Words sinhalaLetter15Word1 = new Words("Sinhala", "ච", "චිත්\u200Dරය", R.drawable.painting, 2);
        Words sinhalaLetter16Word1 = new Words("Sinhala", "ජ", "ජම්බු", R.drawable.rose_apple, 1);
        Words sinhalaLetter16Word2 = new Words("Sinhala", "ජ", "ජනේලය", R.drawable.window, 1);
        Words sinhalaLetter17Word1 = new Words("Sinhala", "ට", "ටයරය", R.drawable.tyres, 1);
        Words sinhalaLetter17Word2 = new Words("Sinhala", "ට", "ටින්", R.drawable.tin, 2);
        Words sinhalaLetter17Word3 = new Words("Sinhala", "ට", "ටෙලිෆෝනය", R.drawable.telephone, 2);
        Words sinhalaLetter18Word1 = new Words("Sinhala", "ඩ", "ඩක්කුව", R.drawable.trolly, 1);
        Words sinhalaLetter19Word1 = new Words("Sinhala", "ත", "තක්කාලි", R.drawable.tomato, 1);
        Words sinhalaLetter19Word2 = new Words("Sinhala", "ත", "තරු", R.drawable.stars, 1);
        Words sinhalaLetter20Word1 = new Words("Sinhala", "ද", "දර", R.drawable.wood, 1);
        Words sinhalaLetter20Word2 = new Words("Sinhala", "ද", "දත", R.drawable.tooth, 1);
        Words sinhalaLetter20Word3 = new Words("Sinhala", "ද", "දම්වැල", R.drawable.chain, 1);
        Words sinhalaLetter21Word1 = new Words("Sinhala", "න", "නළාව", R.drawable.horn, 1);
        Words sinhalaLetter21Word2 = new Words("Sinhala", "න", "නහය", R.drawable.nose, 1);
        Words sinhalaLetter21Word3 = new Words("Sinhala", "න", "නරියා", R.drawable.fox, 1);
        Words sinhalaLetter22Word1 = new Words("Sinhala", "ප", "පහන", R.drawable.lamp, 1);
        Words sinhalaLetter22Word2 = new Words("Sinhala", "ප", "පනාව", R.drawable.comb, 1);
        Words sinhalaLetter23Word1 = new Words("Sinhala", "බ", "බල්ලා", R.drawable.dog, 1);
        Words sinhalaLetter23Word2 = new Words("Sinhala", "බ", "බකමූණා", R.drawable.owl, 1);
        Words sinhalaLetter24Word1 = new Words("Sinhala", "ම", "මල", R.drawable.flower, 1);
        Words sinhalaLetter25Word1 = new Words("Sinhala", "ය", "යතුර", R.drawable.key, 1);
        Words sinhalaLetter26Word1 = new Words("Sinhala", "ර", "රඹුටන්", R.drawable.rambutan, 1);
        Words sinhalaLetter26Word2 = new Words("Sinhala", "ර", "\u200Dරබාන", R.drawable.rabana, 1);
        Words sinhalaLetter27Word1 = new Words("Sinhala", "ල", "ලනුව", R.drawable.rope, 1);
        Words sinhalaLetter28Word1 = new Words("Sinhala", "ව", "වඳුරා", R.drawable.monkey, 1);
        Words sinhalaLetter28Word2 = new Words("Sinhala", "ව", "වළං", R.drawable.pots, 1);
        Words sinhalaLetter29Word1 = new Words("Sinhala", "ස", "සරුංගලය", R.drawable.kite, 1);
        Words sinhalaLetter30Word1 = new Words("Sinhala", "හ", "හඳ", R.drawable.moon, 1);
        Words sinhalaLetter30Word2 = new Words("Sinhala", "හ", "හරකා", R.drawable.buffalo, 1);

        //Tamil words
        //===================================================================================================================================
        Words tamilLetter1Word1 = new Words("Tamil", "அ", "அமஂமா", R.drawable.mother, 1);


        //English words
        //==============================================================================================================================
        Words englishLetter1Word1 = new Words("English", "A", "APPLE", R.drawable.apple, 1);
        Words englishLetter1Word2 = new Words("English", "A", "AXE", R.drawable.axe, 1);
        Words englishLetter1Word3 = new Words("English", "A", "ANT", R.drawable.ant, 1);
        Words englishLetter2Word1 = new Words("English", "B", "BALL", R.drawable.ball, 1);
        Words englishLetter2Word2 = new Words("English", "B", "BOY", R.drawable.boy, 1);
        Words englishLetter2Word3 = new Words("English", "B", "BOOK", R.drawable.book, 1);
        Words englishLetter2Word4 = new Words("English", "B", "BOAT", R.drawable.boat, 1);
        Words englishLetter3Word1 = new Words("English", "C", "CAT", R.drawable.cat, 1);
        Words englishLetter3Word2 = new Words("English", "C", "CAR", R.drawable.car, 1);
        Words englishLetter4Word1 = new Words("English", "D", "DOLL", R.drawable.doll, 1);
        Words englishLetter4Word2 = new Words("English", "D", "DOG", R.drawable.dog, 1);
        Words englishLetter5Word1 = new Words("English", "E", "EYE", R.drawable.eye, 1);
        Words englishLetter5Word2 = new Words("English", "E", "ELEPHANT", R.drawable.elephant, 1);
        Words englishLetter6Word1 = new Words("English", "F", "FISH", R.drawable.fish, 1);
        Words englishLetter6Word2 = new Words("English", "F", "FOX", R.drawable.fox, 1);
        Words englishLetter7Word1 = new Words("English", "G", "GRAPES", R.drawable.grapes, 1);
        Words englishLetter7Word2 = new Words("English", "G", "GOAT", R.drawable.goat, 1);
        Words englishLetter8Word1 = new Words("English", "H", "HAT", R.drawable.hat, 1);
        Words englishLetter8Word2 = new Words("English", "H", "HEN", R.drawable.hen, 1);
        Words englishLetter9Word1 = new Words("English", "I", "ICE CREAM", R.drawable.ice_cream, 1);
        Words englishLetter9Word2 = new Words("English", "I", "INK", R.drawable.ink, 1);
        Words englishLetter10Word1 = new Words("English", "J", "JAM", R.drawable.jam, 1);
        Words englishLetter10Word2 = new Words("English", "J", "JUG", R.drawable.jug, 1);
        Words englishLetter11Word1 = new Words("English", "K", "KETTLE", R.drawable.kettle, 1);
        Words englishLetter11Word2 = new Words("English", "K", "KITE", R.drawable.kite, 1);
        Words englishLetter12Word1 = new Words("English", "L", "LEAF", R.drawable.leaf, 1);
        Words englishLetter12Word2 = new Words("English", "L", "LAMP", R.drawable.lamp, 1);
        Words englishLetter13Word1 = new Words("English", "M", "MANGO", R.drawable.mango, 1);
        Words englishLetter13Word2 = new Words("English", "M", "MOON", R.drawable.moon, 1);
        Words englishLetter14Word1 = new Words("English", "N", "NEST", R.drawable.nest, 1);
        Words englishLetter14Word2 = new Words("English", "N", "NAIL", R.drawable.nail, 1);
        Words englishLetter15Word1 = new Words("English", "O", "ORANGE", R.drawable.orange, 1);
        Words englishLetter15Word2 = new Words("English", "O", "OWL", R.drawable.owl, 1);
        Words englishLetter16Word1 = new Words("English", "P", "PARROT", R.drawable.parrot, 1);
        Words englishLetter16Word2 = new Words("English", "P", "POT", R.drawable.pot, 1);
        Words englishLetter17Word1 = new Words("English", "Q", "QUEEN", R.drawable.queen, 1);
        Words englishLetter17Word2 = new Words("English", "Q", "QUICK", R.drawable.quick, 1);
        Words englishLetter17Word3 = new Words("English", "Q", "QUEUE", R.drawable.queue, 1);
        Words englishLetter18Word1 = new Words("English", "R", "ROSE", R.drawable.rose, 1);
        Words englishLetter18Word2 = new Words("English", "R", "RABBIT", R.drawable.rabbit, 1);
        Words englishLetter18Word3 = new Words("English", "R", "RAIN", R.drawable.rain, 1);
        Words englishLetter19Word1 = new Words("English", "S", "SUN", R.drawable.english_sun, 1);
        Words englishLetter19Word2 = new Words("English", "S", "SEA", R.drawable.sea, 1);
        Words englishLetter19Word3 = new Words("English", "S", "SPOON", R.drawable.spoon, 1);
        Words englishLetter20Word1 = new Words("English", "T", "TOMATO", R.drawable.tomato, 1);
        Words englishLetter20Word2 = new Words("English", "T", "TRAIN", R.drawable.train, 1);
        Words englishLetter21Word1 = new Words("English", "U", "UMBRELLA", R.drawable.umbrella, 1);
        Words englishLetter21Word2 = new Words("English", "U", "UPSET", R.drawable.upset, 1);
        Words englishLetter22Word1 = new Words("English", "V", "VAN", R.drawable.van, 1);
        Words englishLetter22Word2 = new Words("English", "V", "VASE", R.drawable.vase, 1);
        Words englishLetter22Word3 = new Words("English", "V", "VEGETABLE", R.drawable.vegetable, 1);
        Words englishLetter23Word1 = new Words("English", "W", "WATER", R.drawable.water, 1);
        Words englishLetter23Word2 = new Words("English", "W", "WALL", R.drawable.wall, 1);
        Words englishLetter24Word1 = new Words("English", "X", "XMAS", R.drawable.xmas, 1);
        Words englishLetter24Word2 = new Words("English", "X", "XYLOPHONE", R.drawable.xylophone, 1);
        Words englishLetter25Word1 = new Words("English", "Y", "YELLOW", R.drawable.yellow, 1);
        Words englishLetter25Word2 = new Words("English", "Y", "YACHT", R.drawable.yacht, 1);
        Words englishLetter26Word1 = new Words("English", "Z", "ZEBRA", R.drawable.zebra, 1);
        Words englishLetter26Word2 = new Words("English", "Z", "ZIPPER", R.drawable.zipper, 1);

        //Numbers
        //=====================================================================================================================================
        Words numbersOne = new Words("Numbers", "1", "1", R.drawable.one, 1);
        Words numbersTwo = new Words("Numbers", "2", "2", R.drawable.two, 1);
        Words numbersThree = new Words("Numbers", "3", "3", R.drawable.three, 1);
        Words numbersFour = new Words("Numbers", "4", "4", R.drawable.four, 1);
        Words numbersFive = new Words("Numbers", "5", "5", R.drawable.five, 1);
        Words numbersSix = new Words("Numbers", "6", "6", R.drawable.six, 1);
        Words numbersSeven = new Words("Numbers", "7", "7", R.drawable.seven, 1);
        Words numbersEight = new Words("Numbers", "8", "8", R.drawable.eight, 1);
        Words numbersNine = new Words("Numbers", "9", "9", R.drawable.nine, 1);
        Words numbersTen = new Words("Numbers", "10", "10", R.drawable.ten, 2);


        //Add Sinhala Words
        //=================================================
        dataList.add(0, sinhalaLetter1Word1);
        dataList.add(1, sinhalaLetter1Word2);
        dataList.add(2, sinhalaLetter1Word3);
        dataList.add(3, sinhalaLetter2Word1);
        dataList.add(4, sinhalaLetter3Word1);
        dataList.add(5, sinhalaLetter4Word1);
        dataList.add(6, sinhalaLetter5Word1);
        dataList.add(7, sinhalaLetter5Word2);
        dataList.add(8, sinhalaLetter6Word1);
        dataList.add(9, sinhalaLetter7Word1);
        dataList.add(10, sinhalaLetter7Word2);
        dataList.add(11, sinhalaLetter8Word1);
        dataList.add(12, sinhalaLetter9Word1);
        dataList.add(13, sinhalaLetter10Word1);
        dataList.add(14, sinhalaLetter11Word1);
        dataList.add(15, sinhalaLetter11Word2);
        dataList.add(16, sinhalaLetter12Word1);
        dataList.add(17, sinhalaLetter13Word1);
        dataList.add(18, sinhalaLetter13Word2);
        dataList.add(19, sinhalaLetter14Word1);
        dataList.add(20, sinhalaLetter14Word2);
        dataList.add(21, sinhalaLetter14Word3);
        dataList.add(22, sinhalaLetter15Word1);
        dataList.add(23, sinhalaLetter16Word1);
        dataList.add(24, sinhalaLetter16Word2);
        dataList.add(25, sinhalaLetter17Word1);
        dataList.add(26, sinhalaLetter17Word2);
        dataList.add(27, sinhalaLetter17Word3);
        dataList.add(28, sinhalaLetter18Word1);
        dataList.add(29, sinhalaLetter19Word1);
        dataList.add(30, sinhalaLetter19Word2);
        dataList.add(31, sinhalaLetter20Word1);
        dataList.add(32, sinhalaLetter20Word2);
        dataList.add(33, sinhalaLetter20Word3);
        dataList.add(34, sinhalaLetter21Word1);
        dataList.add(35, sinhalaLetter21Word2);
        dataList.add(36, sinhalaLetter21Word3);
        dataList.add(37, sinhalaLetter22Word1);
        dataList.add(38, sinhalaLetter22Word2);
        dataList.add(39, sinhalaLetter23Word1);
        dataList.add(40, sinhalaLetter23Word2);
        dataList.add(41, sinhalaLetter24Word1);
        dataList.add(42, sinhalaLetter25Word1);
        dataList.add(43, sinhalaLetter26Word1);
        dataList.add(44, sinhalaLetter26Word2);
        dataList.add(45, sinhalaLetter27Word1);
        dataList.add(46, sinhalaLetter28Word1);
        dataList.add(47, sinhalaLetter28Word2);
        dataList.add(48, sinhalaLetter29Word1);
        dataList.add(49, sinhalaLetter30Word1);
        dataList.add(50, sinhalaLetter30Word2);

        //Add Tamil Words
        //==================================================
        dataList.add(0, tamilLetter1Word1);

        //Add English Words
        //==================================================
        dataList.add(0, englishLetter1Word1);
        dataList.add(1, englishLetter1Word2);
        dataList.add(2, englishLetter1Word3);
        dataList.add(3, englishLetter2Word1);
        dataList.add(4, englishLetter2Word2);
        dataList.add(5, englishLetter2Word3);
        dataList.add(6, englishLetter2Word4);
        dataList.add(7, englishLetter3Word1);
        dataList.add(8, englishLetter3Word2);
        dataList.add(9, englishLetter4Word1);
        dataList.add(10, englishLetter4Word2);
        dataList.add(11, englishLetter5Word1);
        dataList.add(12, englishLetter5Word2);
        dataList.add(13, englishLetter6Word1);
        dataList.add(14, englishLetter6Word2);
        dataList.add(15, englishLetter7Word1);
        dataList.add(16, englishLetter7Word2);
        dataList.add(17, englishLetter8Word1);
        dataList.add(18, englishLetter8Word2);
        dataList.add(19, englishLetter9Word1);
        dataList.add(20, englishLetter9Word2);
        dataList.add(21, englishLetter10Word1);
        dataList.add(22, englishLetter10Word2);
        dataList.add(23, englishLetter11Word1);
        dataList.add(24, englishLetter11Word2);
        dataList.add(25, englishLetter12Word1);
        dataList.add(26, englishLetter12Word2);
        dataList.add(27, englishLetter13Word1);
        dataList.add(28, englishLetter13Word2);
        dataList.add(29, englishLetter14Word1);
        dataList.add(30, englishLetter14Word2);
        dataList.add(31, englishLetter15Word1);
        dataList.add(32, englishLetter15Word2);
        dataList.add(33, englishLetter16Word1);
        dataList.add(34, englishLetter16Word2);
        dataList.add(35, englishLetter17Word1);
        dataList.add(36, englishLetter17Word2);
        dataList.add(37, englishLetter17Word3);
        dataList.add(38, englishLetter18Word1);
        dataList.add(39, englishLetter18Word2);
        dataList.add(40, englishLetter18Word3);
        dataList.add(41, englishLetter19Word1);
        dataList.add(42, englishLetter19Word2);
        dataList.add(43, englishLetter19Word3);
        dataList.add(44, englishLetter20Word1);
        dataList.add(45, englishLetter20Word2);
        dataList.add(46, englishLetter21Word1);
        dataList.add(47, englishLetter21Word2);
        dataList.add(48, englishLetter22Word1);
        dataList.add(49, englishLetter22Word2);
        dataList.add(50, englishLetter22Word3);
        dataList.add(51, englishLetter23Word1);
        dataList.add(52, englishLetter23Word2);
        dataList.add(53, englishLetter24Word1);
        dataList.add(54, englishLetter24Word2);
        dataList.add(55, englishLetter25Word1);
        dataList.add(56, englishLetter25Word2);
        dataList.add(57, englishLetter26Word1);
        dataList.add(58, englishLetter26Word2);

        //Add Numbers
        //==================================================================
        dataList.add(0, numbersOne);
        dataList.add(1, numbersTwo);
        dataList.add(2, numbersThree);
        dataList.add(3, numbersFour);
        dataList.add(4, numbersFive);
        dataList.add(5, numbersSix);
        dataList.add(6, numbersSeven);
        dataList.add(7, numbersEight);
        dataList.add(8, numbersNine);
        dataList.add(9, numbersTen);

        repository.insert(dataList);
//        Database.list = dataList;

    }

}
