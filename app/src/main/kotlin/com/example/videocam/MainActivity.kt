@file:Suppress("LABEL_NAME_CLASH")

package com.example.videocam

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext

val mcqArrayLevel1 = mutableListOf<Mcq>()

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onResume() {
        super.onResume()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mcqArrayLevel1.add(Mcq("What is 40% of 80 ?",2,"36","40","32","38",1))
        mcqArrayLevel1.add(Mcq("When a number is increased by 216, it becomes 140 % of itself. What is the number ?",0,"540","450","756","675",1))
        mcqArrayLevel1.add(Mcq("What is the LCM of 120 and 450 ?",1,"2400","1800","3600","4800",1))
        mcqArrayLevel1.add(Mcq("If x is less than y by 25% , then y exceed x by ?",0,"33 1/3%","25%","75%","66 2/3%",1))
        mcqArrayLevel1.add(Mcq("If 85 % of a number is added to 75 , then the result is the number itself. The number is :",0,"500","300","400","700",1))
        mcqArrayLevel1.add(Mcq("What is the sum of 40% of 30 and 60% of 30 ",3,"35","40","25","30",1))
        mcqArrayLevel1.add(Mcq("What is 7% % of 800 ?",2,"0.56","0.056","56","5.6",1))
        mcqArrayLevel1.add(Mcq("What is the percentage of 50 paise to 4 rupees ?",0,"12.5","13.5","20","23.5",1))
        mcqArrayLevel1.add(Mcq("What is the probability of getting an even number when a dice is rolled down once?",1,"3/5","1/2","2/6","4/6",1))
        mcqArrayLevel1.add(Mcq("What is the area of the square (in sq.units) whose side is 4 cm ?",3,"20","12","16","18",1))
        mcqArrayLevel1.add(Mcq("What is the probability of drawing a red card from a pack of 52 units ?",0,"1/26","2/26","2/28","1/52",1))
        mcqArrayLevel1.add(Mcq("What is the probability of getting head when a coin is tossed 1 time ?",2,"1.0","2.5","0.5","1.5",1))
        mcqArrayLevel1.add(Mcq("What is the LCM(Least Common Multiple) of 1 and 2 ?",1,"1","2","3","0",1))
        mcqArrayLevel1.add(Mcq("What is 100% of 1 ?",2,"0.001","0.1","1","0.01",1))
        mcqArrayLevel1.add(Mcq("If there are 50 students in a class and 20% of them are present , find out how many are present?",3,"20","30","15","10",1))
        mcqArrayLevel1.add(Mcq("What is the GCD(Greatest Common Divisor) of 1 and 2 ?",1,"0","1","2","3",1))
        mcqArrayLevel1.add(Mcq("What is the HCF(Highest Common Factor) of 1 and 2 ?",1,"0","1","2","3",1))
        mcqArrayLevel1.add(Mcq("0.75 + 0.25 = ? ",2,"0.75","0.5","1.0","1.5",1))
        mcqArrayLevel1.add(Mcq("What is the least number which divides both 2 and 10 ? ",2,"0","2","1","10",1))
        mcqArrayLevel1.add(Mcq("What is the cube of 3 ? ",3,"1","3","24","27",1))
        mcqArrayLevel1.add(Mcq("Angle between 60 degree & 30 degree is (in degrees) ? ",0,"30","40","60","15",1))
        mcqArrayLevel1.add(Mcq("1 to the power of 2 = ?",2,"2","0","1","2",1))
        mcqArrayLevel1.add(Mcq("30 % 6 = ?",3,"30","6","10","5",1))
        mcqArrayLevel1.add(Mcq("What is last digit of 2 * 3 = ?",2,"2","4","6","8",1))
        mcqArrayLevel1.add(Mcq("What is the last digit when 20 divided by 4 = ?",2,"4","0","5","3",1))
        mcqArrayLevel1.add(Mcq("50% of 50 = ?",3,"10","30","35","25",1))
        mcqArrayLevel1.add(Mcq("50% of 5 = ?",3,"50","10","15","2.5",1))
        mcqArrayLevel1.add(Mcq("Which is the Least Number ? -100 (or) -101 ",3,"both","neither of them","-100","-101",1))
        mcqArrayLevel1.add(Mcq("Which is the Greatest Number ? -100 (or) -101 ",3,"both","neither of them","-100","-101",1))
        mcqArrayLevel1.add(Mcq("Which is the Least Number ? 0.1 (or) 0.01 ",2,"both","neither of them","0.01","0.1",1))
        mcqArrayLevel1.add(Mcq("Distance travelled by a vehicle of speed 30 Km/hr in 2 hrs is ?",3,"30","45","90","60",2))
        mcqArrayLevel1.add(Mcq("Speed of a car when it crosses a distance of 50 Km in 5 hrs is  ?",0,"10","25","50","30",2))
        mcqArrayLevel1.add(Mcq("Time taken for a car of speed 40Km/hr to travel 120Kms is ?",3,"0","1","2","3",2))
        mcqArrayLevel1.add(Mcq("333 / 3 / 3 = ?",2,"333","111","37","3",2))
        mcqArrayLevel1.add(Mcq("Find the Leap Year",2,"1702","1706","1708","1710",2))
        mcqArrayLevel1.add(Mcq("Find the Leap Year",0,"1600","2100","1800","1900",2))
        mcqArrayLevel1.add(Mcq("Anju ranks 18th from the top in a class of 90 students. What is her position from the bottom ?",3,"72","71","74","73",2))
        mcqArrayLevel1.add(Mcq("In a row of 65 students Vignesh stands 21st from the right ,then what is position from the left end ?",2,"43","44","45","48",2))
        mcqArrayLevel1.add(Mcq("Starting from either end, if your position is 21,then how many people are there in the row ?",3,"20","22","42","41",2))
        mcqArrayLevel1.add(Mcq("In a class Ram is 13th from the top & 46th from the bottom, the total strength of the class is ?",3,"60","59","57","58",2))
        mcqArrayLevel1.add(Mcq("In a class of 60 students the ratio of Boys to Girls is 3 : 2 , the no. of girls in the class is ?",2,"48","36","24","12",2))
        mcqArrayLevel1.add(Mcq("In a class there are 36 boys & 48 girls ,then ratio of Girls to Boys is ?",1,"3:4","4:3","2:3","2:1",2))
        mcqArrayLevel1.add(Mcq("If 6th Oct,2002 was Sunday ,then, 31 st of that same month & year will be ?",1,"Wednesday","Thursday","Friday","Saturday",2))
        mcqArrayLevel1.add(Mcq("If today is Sunday , then day before yesterday is ?",0,"Friday","Saturday","Wednesday","Tuesday",2))
        mcqArrayLevel1.add(Mcq("If today is Sunday , then day after tomorrow is ?",3,"Monday","Saturday","Friday","Tuesday",2))
        mcqArrayLevel1.add(Mcq("How many times 29th date will occur in a LEAP Year",0,"12","11","13","10",2))
        mcqArrayLevel1.add(Mcq("How many times 28th date will occur in a LEAP Year",0,"12","11","13","10",2))
        mcqArrayLevel1.add(Mcq("How many times 28th date will occur in a NORMAL Year",0,"12","11","13","10",2))
        mcqArrayLevel1.add(Mcq("How many times 31th day will occur in a NORMAL Year",1,"6","7","8","9",2))
        mcqArrayLevel1.add(Mcq("How many times 30th day will occur in a NORMAL Year",0,"11","12","10","9",2))
        mcqArrayLevel1.add(Mcq("How many times 29th day will occur in a LEAP Year",0,"12","11","13","10",2))
        mcqArrayLevel1.add(Mcq("In a NORMAL year how many days are there ? (Choose the most apporpriate option)",2,"363","364","365","366",2))
        mcqArrayLevel1.add(Mcq("In a LEAP year how many days are there ?",2,"364 1/4","365","366","365 1/4",2))
        mcqArrayLevel1.add(Mcq("In a NON-LEAP year how many days are there in a calendar ?",1,"364 1/4","365","366","365 1/4",2))
        mcqArrayLevel1.add(Mcq("Angle(in degrees) between the hour hand & minute hand when the time is at 1.00 AM is ?",1,"24","30","48","60",2))
        mcqArrayLevel1.add(Mcq("Angle(in degrees) between the hour hand & minute hand when the time is at 12 noon is ?",3,"45","180","90","0",2))
        mcqArrayLevel1.add(Mcq("Angle(in degrees) between the hour hand & minute hand when the time is at 3.00 AM is ?",1,"60","90","120","150",2))
        mcqArrayLevel1.add(Mcq("Angle(in degrees) between the hour hand & second hand when the time is at 1.00 AM is ?",1,"24","30","48","60",2))
        mcqArrayLevel1.add(Mcq("Angle(in degrees) between the hour hand & minute hand when the time is at 12 noon is ?",0,"0","45","90","180",2))
        mcqArrayLevel1.add(Mcq("If A means +, B means -,C means * & D means / ,then 18 C 14 A 6 B 16 D 4 = ?",1,"252","254","256","250",2))
        mcqArrayLevel1.add(Mcq("If A means +, B means -,C means * & D means / ,then find X ; X = 100 D 20 C 3 A 10 B 5",3,"5","10","15","20",3))
        mcqArrayLevel1.add(Mcq("If + means /, - means *,* means - & / means + ,then 38 + 19 - 16 * 17 / 3 = ?",2,"32","17","18","17",3))
        mcqArrayLevel1.add(Mcq("If 11th April 1994 was Sunday, then, which day of the week was 681 days back ?",0,"Friday","Thursday","Sunday","Saturday",3))
        mcqArrayLevel1.add(Mcq("If 25th September 2007 was Saturday, then, which day of the week will be after 130 days ?",1,"Monday","Wednesday","Saturday","Sunday",3))
        mcqArrayLevel1.add(Mcq("If 1st March 2007 was Sunday, then, which day of the week will fall on 27th March,2007 ?",3,"Monday","Wednesday","Saturday","Friday",3))
        mcqArrayLevel1.add(Mcq("If 17th December 1994 was Sunday, then, which day of the week was 830 days back ?",3,"Monday","Wednesday","Sunday","Saturday",3))
        mcqArrayLevel1.add(Mcq("If today is Tuesday , then which day of the week will fall after 4 power 6 days ?",2,"Thursday","Friday","Wednesday","Monday",3))
        mcqArrayLevel1.add(Mcq("If 11th March 2018 is Monday,then, which day of the week was 2 power 17 days back ?",0,"Thursday","Friday","Wednesday","Monday",3))
        mcqArrayLevel1.add(Mcq("Square root of 196 is ?",3,"12","13","16","14",3))
        mcqArrayLevel1.add(Mcq("Cube root of 125 is ?",2,"15","25","5","3",3))
        mcqArrayLevel1.add(Mcq("Cube root of .125 is ?",2,"1.5","2.5",".5",".3",3))
        mcqArrayLevel1.add(Mcq("Square root of 2.56 is ?",0,"1.6",".16",".18",".016",3))
        mcqArrayLevel1.add(Mcq("What is the probability of getting 5 when a dice is thrown once ?",3,"1/2","1/5","1/4","1/6",3))
        mcqArrayLevel1.add(Mcq("What is the probability of getting an odd number when a dice is thrown once ?",2,"1/4","1/5","1/2","1/6",3))
        mcqArrayLevel1.add(Mcq("What is the probability of getting the same digit on both dice when two dice are bounced simultaneously ?",3,"1/2","1/5","1/4","1/6",3))
        mcqArrayLevel1.add(Mcq("Three coins are tossed .What is the probability of getting atleast two heads ?",0,"1/2","1/5","1/4","1/6",3))
        mcqArrayLevel1.add(Mcq("Three coins are tossed .What is the probability of getting atmost two heads ?",3,"3/4","1/4","3/8","7/8",3))
        mcqArrayLevel1.add(Mcq("Probability of getting the sum as 8 when two dices are thrown together is ?",1,"5/6","5/36","5/18","1/6",3))
        mcqArrayLevel1.add(Mcq("Probability of getting the sum as 9 when two dices are thrown together is ?",3,"5/6","5/36","5/18","1/9",3))
        mcqArrayLevel1.add(Mcq("Two dices are thrown simultaneously.What is the probability of getting two numbers where their product is even ?",2,"1/2","3/8","3/4","5/16",3))
        mcqArrayLevel1.add(Mcq("Probability of getting the sum of 10 (or) 11 when two dices are thrown simultaneously is ?",3,"1/4","1/6","7/12","5/36",3))
        mcqArrayLevel1.add(Mcq("Probability of getting the sum as a prime number when two dices are thrown together is ?",2,"1/6","1/2","5/12","7/9",3))
        mcqArrayLevel1.add(Mcq("In a simultaneous throw of a pair of dice ,find the probability of getting the total more than 7 ",2,"5/36","5/18","5/12","none",3))
        mcqArrayLevel1.add(Mcq("Two dices are thrown together. What is the probability that the sum of the numbers on the two faces is divisible by 4 (or) 6 ?",3,"7/36","11/18","5/18","7/18",3))
        mcqArrayLevel1.add(Mcq("Probability of getting the sum as 6 when two dices are thrown together is ?",2,"5/16","5/26","5/36","1/6",3))
        mcqArrayLevel1.add(Mcq("By drawing a card from a pack of 52 cards, what is the probability that the drawn card is a king ?",0,"1/13","5/36","2/13","5/13",4))
        mcqArrayLevel1.add(Mcq("By drawing a card from a pack of 52 cards, what is the probability that the drawn card is a black colour ?",1,"1/13","1/2","1/3","1/4",4))
        mcqArrayLevel1.add(Mcq("By drawing a card from a pack of 52 cards, what is the probability that the drawn card is a jack ?",3,"5/13","5/36","2/13","1/13",4))
        mcqArrayLevel1.add(Mcq("What is the LCM(Least Common Multiple) of all even numbers between 5 & 13 ?",1,"100","120","150","160",4))
        mcqArrayLevel1.add(Mcq("20% can be expressed in fraction as ?",3,"1/2","1/4","1/6","1/5",4))
        mcqArrayLevel1.add(Mcq("30% can be expressed in fraction as ?",2,"3/30","3/10","3/100","2/15",4))
        mcqArrayLevel1.add(Mcq("70% can be expressed in fraction as ?",0,"7/10","7/1000","70/10","7/5",4))
        mcqArrayLevel1.add(Mcq("80% can be expressed in fraction as ?",2,"2/5","8/5","4/5","1/5",4))
        mcqArrayLevel1.add(Mcq("100% can be expressed as ?",0,"1","2","3","4",4))
        mcqArrayLevel1.add(Mcq("10% can be expressed in fraction as ?",2,"1/1","1/1000","1/10","1/20",4))
        mcqArrayLevel1.add(Mcq("125% can be expressed in fraction as ?",3,"125/8","5/9","5/7","5/4",4))
        mcqArrayLevel1.add(Mcq("40% can be expressed in fraction as ?",0,"2/5","1/5","5/6","8/5",4))
        mcqArrayLevel1.add(Mcq("60% can be expressed in fraction as ?",2,"6/5","6/8","3/5","1/5",4))
        mcqArrayLevel1.add(Mcq("130% can be expressed in fraction as ?",0,"13/10","13/100","260/100","13/5",4))
        mcqArrayLevel1.add(Mcq("150% can be expressed in fraction as ?",3,"1/2","6/2","5/2","3/2",4))
        mcqArrayLevel1.add(Mcq("5 * 8 = 28, 3 * 7 = 12, 8 * 6 = 35, 13 * 13= ?",3,"169","130","140","144",4))
        mcqArrayLevel1.add(Mcq(" 5 + 7 + 2 = 725, 6 + 9 + 0 = 906, 8 + 4 + 3 = ?",2,"815","384","438","834",4))
        mcqArrayLevel1.add(Mcq("4 * 5 = 42, 5 * 6 = 56, 6 * 7 = 72, 7 * 8 = ?",0,"90","84","102","92",4))
        mcqArrayLevel1.add(Mcq("Three boys A, B, C are sitting in the a line horizontally, A sits to the right of C and B sits to the right of A, who sits at the centre ?",0,"A","B","C","D",4))
        mcqArrayLevel1.add(Mcq("Ram celebrated his birthday on 17th July 2017 & the day was Monday. Find out in which upcoming year will he celebrate his birthday again on Monday",2,"2022","2024","2023","2021",4))
        mcqArrayLevel1.add(Mcq("Raghu celebrated his birthday on 11th January 2020 and the day was Saturday. Find out in which upcoming year will he celebrate his birthday again on Saturday ?",2,"2026","2027","2025","2028",4))
        mcqArrayLevel1.add(Mcq("4, 9, 16, 25, ?",2,"49","64","36","81",4))
        mcqArrayLevel1.add(Mcq("8, 27, 64, 125, ?",0,"216","343","512","729",4))
        mcqArrayLevel1.add(Mcq("3, 8, 15, 24, ?",3,"48","63","80","35",4))
        mcqArrayLevel1.add(Mcq("7, 26, 63, 124, ?",1,"342","215","511","728",4))
        mcqArrayLevel1.add(Mcq("2, 6, 24, 120, 720, ?",0,"5040","5020","5080","5200",5))
        mcqArrayLevel1.add(Mcq("4, 4, 8, 24, 96, 480, 2880, ?",1,"20601","20160","22160","22320",5))
        mcqArrayLevel1.add(Mcq("720, 120, 24, 6, 2, ?",3,"0","1.5","3","1",5))
        mcqArrayLevel1.add(Mcq("2, 6, 12, 20, 30, 42, ?",0,"56","64","72","80",5))
        mcqArrayLevel1.add(Mcq("42, 30, 20, 12, 6, ?",1,"1","2","3","4",5))
        mcqArrayLevel1.add(Mcq("0, 3, 8, 15, 24, ?",2,"36","33","35","38",5))
        mcqArrayLevel1.add(Mcq("0, 7, 26, 63, 124, ?",1,"216","215","217","218",5))
        mcqArrayLevel1.add(Mcq("Average of 1,2,3 is ?",1,"1","2","3","0",5))
        mcqArrayLevel1.add(Mcq("Average of 1,3 is ?",1,"1","2","3","1.5",5))
        mcqArrayLevel1.add(Mcq("Average of 10,20,30,40 is ?",0,"25","20","35","30",5))
        mcqArrayLevel1.add(Mcq("Mean of 1,2,3 is ?",1,"1","2","3","0",5))
        mcqArrayLevel1.add(Mcq("Mean of 1,3 is ?",1,"1","2","3","1.5",5))
        mcqArrayLevel1.add(Mcq("Mean of 10,20,30,40 is ?",0,"25","20","35","30",5))
        mcqArrayLevel1.add(Mcq("What is the last digit of the following expression : 35 * 63 * 67 * 21 * 43",2,"3","1","5","7",5))
        mcqArrayLevel1.add(Mcq("What is the last digit of the following expression : 36 * 64 * 68 * 22 * 44",0,"6","4","6","2",5))
        mcqArrayLevel1.add(Mcq("What is the last digit of the following expression : 35 * 60 * 67 * 24 * 43",1,"6","0","5","0",5))
        mcqArrayLevel1.add(Mcq("What is the last digit of the following expression : 35 * 63 * 67 * 20 * 43",3,"3","1","5","0",5))
        mcqArrayLevel1.add(Mcq("What is the unit digit of the following expression : 35 * 63 * 67 * 21 * 43",2,"3","1","5","7",5))
        mcqArrayLevel1.add(Mcq("What is the unit digit of the following expression : 36 * 64 * 68 * 22 * 44",0,"6","4","6","2",5))
        mcqArrayLevel1.add(Mcq("What is the unit digit of the following expression : 35 * 60 * 67 * 24 * 43",1,"6","0","5","0",5))
        mcqArrayLevel1.add(Mcq("What is the unit digit of the following expression : 35 * 63 * 67 * 20 * 43",3,"3","1","5","0",6))
        mcqArrayLevel1.add(Mcq("What is the one's digit of the following expression : 35 * 63 * 67 * 21 * 43",2,"3","1","5","7",6))
        mcqArrayLevel1.add(Mcq("What is the one's digit of the following expression : 36 * 64 * 68 * 22 * 44",0,"6","4","6","2",6))
        mcqArrayLevel1.add(Mcq("What is the one's digit of the following expression : 35 * 60 * 67 * 24 * 43",1,"6","0","5","0",6))
        mcqArrayLevel1.add(Mcq("What is the one's digit of the following expression : 35 * 63 * 67 * 20 * 43",3,"3","1","5","0",6))
        mcqArrayLevel1.add(Mcq("What is the last digit of the following expression : 9 * 99 * 999 ",2,"1","3","9","0",6))
        mcqArrayLevel1.add(Mcq("$4000 is divided into two parts in the ratio 6 : 2 , the second part is ?",0,"$1000","$3000","$2000","$2500",6))
        mcqArrayLevel1.add(Mcq("$4000 is divided into three parts in the ratio 6 : 2 : 2, the second part is ?",3,"$1000","$400","$200","$800",6))
        mcqArrayLevel1.add(Mcq("If m : n = 3 : 2, then (4m + 5n) : (4m - 5n) equals ?",2,"4 : 9","9 : 4","11 : 1","9 : 1",6))
        mcqArrayLevel1.add(Mcq("If x runs are scored by A, y runs by B and z runs by C, then x : y = y : z = 3 : 2 . If total number of runs scored by A, B and C together is 342, the runs  scored by each would be respectively is ?",1,"144,96,64","162,108,72","180,120,80","189,126,84",6))
        mcqArrayLevel1.add(Mcq("The ratio of boys and girls in a college is 5 : 3. If 50 boys leave the college and 50 girls join the college, the ratio becomes 9 : 7. The number of boys in the college initially was ?",2,"300","400","500","600",6))
        mcqArrayLevel1.add(Mcq("A and B can separately do a piece of work in 6 days and 12 days respectively. How many days will they together take to do the work ?",3,"9","18","6","4",6))
        mcqArrayLevel1.add(Mcq("A and B can separately do a piece of work in 6 days and 9 days respectively. How many days will they together take to do the work ?",2,"7.5","5.4","3.6","3",6))
        mcqArrayLevel1.add(Mcq("In what proportion must a grocer mix sugar at $12 per Kg and $7 per Kg ,so as to make a mixture worth $8 per Kg?",1,"7 : 12","1 : 4","2 : 3","12 : 7",6))
        mcqArrayLevel1.add(Mcq("Marked price of the clock is $3200 , if it is sold at a discount of 20% , then , what is the selling price (in $) ? ",2,"2650","2760","2560","2460",6))
        mcqArrayLevel1.add(Mcq("A, B and C are partners of a company. During a particular year A received one-third of the profit, B received one-fourth of the profit and C received the remaining $5,000. How much did A receive ?",0,"$4,000","$5,000","$3,000","$1,000",6))
        mcqArrayLevel1.add(Mcq("If the sum of the digits of any integer between 100 and 1000 is subtracted from the same integer,the resulting number is always divisible by ?",3,"2","5","6","9",6))
        mcqArrayLevel1.add(Mcq("How many numbers between 400 and 800 are divisble by 4, 5 and 6 ?",0,"7","8","9","10",6))
        mcqArrayLevel1.add(Mcq("If the number formed by the last two digits of a three digit integer is an integral multiple of 6, the original integer itself is always divisible by ?",2,"6","3","2","12",6))
        mcqArrayLevel1.add(Mcq("If 34N is divisible by 11, then find N ?",0,"1","3","4","9",6))
        mcqArrayLevel1.add(Mcq("What least number must be subtracted from 3401, so that the sum is completely divisble by 11 ?",2,"3","1","2","0",7))
        mcqArrayLevel1.add(Mcq("Which smallest number must be added to 100, so that the resulting number is completely divisible by 6 ?",0,"2","3","5","4",7))
        mcqArrayLevel1.add(Mcq("How many two digit numbers are there which end in 7 are divisible by 3 ?",0,"3","2","5","4",7))
        mcqArrayLevel1.add(Mcq("If 34P8 is divisible by 9, what is the value of P ?",1,"2","3","4","5",7))
        mcqArrayLevel1.add(Mcq("What is the least number that must be added to 11158, so that the sum is divisible by 77 ?",2,"9","8","7","5",7))
        mcqArrayLevel1.add(Mcq("Which of the following can't be the unit's digit of a perfect square ?",0,"8","9","6","4",7))
        mcqArrayLevel1.add(Mcq("The digit in unit's place of the product 81 * 82 * 83 *.......* 89 is",0,"0","5","1","7",7))
        mcqArrayLevel1.add(Mcq("What is the digit in the unit place of 2 power 51 ?",1,"2","8","1","4",7))
        mcqArrayLevel1.add(Mcq("The denominator of a fraction is 3 more than its numerator. If the numerator is increased by 7 and the denominator is decreased by 2, we obtain 2. The sum of numerator and denominator of the fraction is ?",1,"5","13","17","19",7))
        mcqArrayLevel1.add(Mcq("In an office, there are 108 tables and 132 chairs. If 1/6 of the tables and 1/4 of the chairs are broken, how many people can work in the office if each person requires one table and one chair?",0,"90","86","99","92",7))
        mcqArrayLevel1.add(Mcq("To cover a certain distance with a speed of 60 Km/hr, a train takes 15 hours. If it covers the same distance in 12 hours, what will be it's speed (in Km/hr) ?",2,"65","70","75","80",7))
        mcqArrayLevel1.add(Mcq("The mean of 25 numbers is 14. If 3 is added to every number, what will be the new mean ?",0,"17","15","14","18",7))
        mcqArrayLevel1.add(Mcq("What is the median of the distribution : 34, 22, 13, 11, 27, 19, 25, 16 ?",2,"19","21.5","20.5","22",7))
        mcqArrayLevel1.add(Mcq("Find the distance from origin point to point (-3,4).",0,"5","4","3","7",7))
        mcqArrayLevel1.add(Mcq("What is the distance between the points P(8,5) and Q(4,2).",3,"6","4","3","5",7))
        mcqArrayLevel1.add(Mcq("If the distance between the points (8,P) and (4,3) is 5, then, find the value of P ?",2,"6","0","Both A and B","None",8))
        mcqArrayLevel1.add(Mcq("If x < 0 and y > 0 , then, in which quarter is the point (x,y) is ",1,"2","8","1","4",8))
        mcqArrayLevel1.add(Mcq("The sum of money that will yield Rs.60 as simple interest at the rate of 6% per annum in 5 years is (in Rs.)?",0,"200","225","175","300",8))
        mcqArrayLevel1.add(Mcq("The simple interest on a sum for 5 years is two-fifth of the sum. The rate of interest per annum is ?",1,"0.1","0.08","0.06","0.04",8))
        mcqArrayLevel1.add(Mcq("A certain sum becomes Rs.840 in 3 years and Rs.1200 in 7 years at simple interest. What is the value of the principal (in Rs.)",3,"520","670","620","570",8))
        mcqArrayLevel1.add(Mcq("A sum amounts to double in 8 years by simple interest, then rate of simple interest per annum is (in %) ? ",0,"12.5","10","15","20",8))
        mcqArrayLevel1.add(Mcq("The simple interest on Rs.4000 in 3 years at the rate of x% per annum equals the simple interest on Rs.5000 at the rate of 12% per annum in 2 years. Find x (in %)?",2,"6","8","10","9",8))
        mcqArrayLevel1.add(Mcq("The compound interest on Rs.1000 at 10 % per annum for 3 years in (Rs.) ?",0,"331","1331","300","1300",8))
        mcqArrayLevel1.add(Mcq("The  amount received at 8% per annum in compound interest after 2 years is Rs.72,900. What was the principal in (Rs.)?",3,"65000","67500","60000","62500",8))
        mcqArrayLevel1.add(Mcq("The compound interest on a certain sum of money for 2 years at 5% per annum is Rs.328,then, the sum (in Rs.) ?",0,"3200","3600","3400","3800",8))
        mcqArrayLevel1.add(Mcq("By selling a car for Rs.64,000, Mr.Rao lost 20% , then, the cost price of the car is (in Rs.)?",2,"72000","76800","80000","84000",8))
        mcqArrayLevel1.add(Mcq("If the cost price of an article is 80% of it's selling price, then the profit percentage is ?",1,"20","25","24","22.5",8))
        mcqArrayLevel1.add(Mcq("A salesman expects a gain of 13% on his cost price. If in a month his sale was Rs.7,91,000, then , what was his profit  (in Rs.) ?",2,"85000","93000","91000","97000",8))
        mcqArrayLevel1.add(Mcq("If a man estimates his loss as 20% of the selling price, then, his loss percent is ?",0,"50/3","40/3","25","20",8))
        mcqArrayLevel1.add(Mcq("A milkman bought 70 litres of milk for Rs.630 and added 5 litres of water. If he sells it at Rs.9.00 per litre, his profit percentage is ?",3,"8 1/5","7","8 2/5","7 1/7",8))
        mcqArrayLevel1.add(Mcq("A man of 6 ft tall casts a shadow of 4 ft long, at the same time when a flag pole casts a shadow of 50 ft long. The height of the flag pole is (in ft) ?",0,"75","80","60","70",9))
        mcqArrayLevel1.add(Mcq("If North West is called as south ,then what east will be called as now ?",0,"North West","North East","South West","South East",9))
        mcqArrayLevel1.add(Mcq("Ram started walking from his house towards west and after walking 5 Kms ,he turned left and walked 5 Kms again to reach his Office. Point A is 4 Kms away from his office. His house is in which direction from Point A",3,"North West","South East","South West","North East",9))
        mcqArrayLevel1.add(Mcq("If A and B together can finish a piece of work in 20 days, B and C in 10 days , C and A in 12 days,then , A,B,C jointly can finish the same work in how many days?",2,"4 2/7","30","8 4/7","7/60",9))
        mcqArrayLevel1.add(Mcq("A can do a piece of work in 18 days. He worked at it for 12 days and B finished the remaining work in 8 days. B alone can do the whole work in how many days ?",3,"16","25","28","24",9))
        mcqArrayLevel1.add(Mcq("A, B and C can do a job working alone in 6, 9 and 18 days respectively. They all work together for 1 day, then, A and B quit. How many days C working alone will take to complete the remainder of the job ?",0,"12","8","1","4",9))
        mcqArrayLevel1.add(Mcq("M is thrice as good as workman as N and together they finish a piece of work in 30 days. In how many days will M alone finish the work ?",3,"50","60","45","40",9))
        mcqArrayLevel1.add(Mcq("If 7 men working 7 hrs a day for each of 7 days produce 7 units of work, then, the units of work produced by 5 men working 5 hrs. a day for each of 5 days is ?",1,"25/343","125/49","49/125","343/25",9))
        mcqArrayLevel1.add(Mcq("Two pipes A and B can fill a tank in 20 mins. and 30 mins. respectively. If both pipes are opened together, the time taken to fill the tank is (in mins.)",0,"12","14","25","15",9))
        mcqArrayLevel1.add(Mcq("One tap can fill a tank in 40 mins. and another tap can make the filled tank empty in 60 mins. If both the taps are open, in how many hours will the empty tank be filled (in hours) ?",2,"2.5","3","2","3.5",9))
        mcqArrayLevel1.add(Mcq("A person has to travel a distance of 30 Km. He finds that he has covered 5/6 th of the distance in 3 hrs. and 20 mins. What is his speed in Km/Hr ?",0,"5.4","6.3","6","7.5",10))
        mcqArrayLevel1.add(Mcq("18 years ago, ratio of A's age to B's age was 8 : 13, their present ratios are 5 : 7, what is the present age of A ?",0,"50","60","40","70",10))
        mcqArrayLevel1.add(Mcq("In an alloy, the ratio of copper and zinc is 5 : 2. If 1.250 Kg of zinc is mixed in 17 Kg 500 gm of an alloy,then, the ratio of zinc and copper will be ?",3,"2 : 3","2 : 2","3 : 2","1 : 2",10))
        mcqArrayLevel1.add(Mcq("The income of A, B and C are in the ratio 3 : 7 : 4 and their expenses are in ratio 4 : 3 : 5. If A saves Rs.300 out of an income of Rs.2,400, the savings of B and C are respectively(in Rs.)",0,"4025 and 575","1575 and 2625","2750 and 1525","3725 and 1525",10))
        mcqArrayLevel1.add(Mcq("Rs. 68000 is divided among A, B and C in ratio of 1/2 : 1/4 : 5/16. The difference of the greatest and the smallest part is (in Rs.)",3,"6000","14440","9200","16000",10))
        mcqArrayLevel1.add(Mcq("Raju ate 3/8 part of a pizza and Adam ate 3/10 part of the remaining pizza, then Renu ate 4/7 part of the pizza that was left. What fraction of the pizza is still left ?",2,"1/4","5/12","3/16","1/8",10))
        mcqArrayLevel1.add(Mcq("In an exam, the no. of those who passed and the no. of failed were in the ratio 25 : 4. If five more had appeared and the no. of failures was 2 less than the earlier, the ratio of passers to failures would have been 22 : 3, the total no. who appeared at the exam is ?",2,"180","155","145","155",10))
        mcqArrayLevel1.add(Mcq("A sum of Rs.76 is divided among A, B and C in such a way that A gets Rs.7 more than that what B gets and B gets Rs.6 more than what C gets. The ratio of shares of A, B, C is ?",0,"32:25:19","19:24:33","32:24:27","19:25:33",10))
        mcqArrayLevel1.add(Mcq("Rs.3,000 is divided between A, B and C, so that A receives 1/3 as much as B and C together receive and B receives 2/3 as much as A and C together receive, then the share of C is ? (in Rs.) ",3,"600","525","1625","1050",10))
        mcqArrayLevel1.add(Mcq("The sides of a triangle having area 7776 sq.cm are in the ratio 3 : 4 : 5, then perimeter of the triangle is (in sq. units) is ?",1,"424","432","420","416",10))

        setContent {
            var showNextActivity by remember { mutableStateOf(false) }

            MaterialTheme {
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    if (showNextActivity) {

                    } else {
                        VideoPlayerComposable(
                                context = this@MainActivity,
                                onVideoEnd = { showNextActivity = true }
                        )
                    }
                    // Center the content within the surface
                    Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val shuffledAllQuestions = mcqArrayLevel1.shuffled()
                        MyApp(shuffledAllQuestions)
                    }
                }
            }
        }
    }
}

@Composable
fun VideoPlayerComposable(context: Context, onVideoEnd: () -> Unit) {
    AndroidView(factory = { ctx ->
        VideoView(ctx).apply {
            layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            )
            setVideoURI(Uri.parse("android.resource://${context.packageName}/${R.raw.vio}"))
            setOnPreparedListener { mp ->
                mp.isLooping = true // Set looping to true
                mp.start()
                // Adjust the video scaling to fill the screen and maintain aspect ratio
                val videoWidth = mp.videoWidth
                val videoHeight = mp.videoHeight
                val aspectRatio = videoWidth.toFloat() / videoHeight.toFloat()

                // Get the screen width and height
                val displayMetrics = context.resources.displayMetrics
                val screenWidth = displayMetrics.widthPixels
                val screenHeight = displayMetrics.heightPixels
                val screenAspectRatio = screenWidth.toFloat() / screenHeight.toFloat()

                val layoutParams = this.layoutParams
                if (aspectRatio > screenAspectRatio) {
                    // Video is wider than the display
                    layoutParams.width = screenWidth
                    layoutParams.height = (screenWidth / aspectRatio).toInt()
                } else {
                    // Video is taller than the display
                    layoutParams.height = screenHeight
                    layoutParams.width = (screenHeight * aspectRatio).toInt()
                }
                this.layoutParams = layoutParams
            }
            setOnErrorListener { mp, what, extra ->
                Log.e("VideoView", "Error with what: $what and extra: $extra")
                true
            }
            setOnCompletionListener { mp ->
                // Restart the video when it completes
                mp.start()
                // Call the onVideoEnd callback if needed
                onVideoEnd()
            }
        }
    })
}


@Composable
fun MyApp(mcqArray: List<Mcq>) {
    var radioOptions by remember { mutableStateOf(listOf("Option 1", "Option 2", "Option 3", "Option 4")) }
    var selectedOption by remember { mutableStateOf("") }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var marks by remember { mutableStateOf(0f) }

    val context = LocalContext.current

    if (currentQuestionIndex < mcqArray.size) {
        val currentQuestion = mcqArray[currentQuestionIndex]

        radioOptions = currentQuestion.Options.toList()
        // Use a Card composable to display the content with styling and elevation
        Box(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(16.dp)) // Set the background color to light pink with transparency
                    .padding(16.dp)
        ) {
            Column(
                    modifier = Modifier.padding(10.dp), // Add inner padding for content
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the current marks

                Text(currentQuestion.Question)

                // Add a Spacer to create some space between the Text and the Button
                radioOptions.forEach { option ->
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                    ) {
                        RadioButton(
                                selected = selectedOption == option,
                                onClick = { selectedOption = option }
                        )
                        Text(text = option, modifier = Modifier.padding(start = 8.dp, top = 12.dp))
                    }
                }
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                // Add a Button composable
                Button(onClick = {
                    if (selectedOption.isNotEmpty()) {
                        // Pass the selected question and answer to codeForTask
                        val result =
                            codeForTask(currentQuestion, radioOptions.indexOf(selectedOption))

                        // Check if the answer is correct
                        if (result.last() == "Correct!") {
                            marks += currentQuestion.HardnessLevel
                        } else {
                            // If the answer is wrong, decrease marks by half
                            marks = (marks - 0.5).toFloat()
                        }

                        // Shuffle options for the next question
                        radioOptions = result.subList(0, 4).shuffled()

                        // Increment the question index
                        currentQuestionIndex++

                        // Reset selected option
                        selectedOption = ""

                        // Remove the completed question from the list
                        mcqArrayLevel1.removeAt(currentQuestionIndex - 1)
                    }
                }) {
                    Text("Submit")
                }

                    Button(onClick = {

                    // Skip the current question by removing it from the list
                    mcqArrayLevel1.removeAt(currentQuestionIndex)

                    // Shuffle options for the next question
                    radioOptions = radioOptions.shuffled()

                    // Increment the question index
                    currentQuestionIndex++
                }) {
                    Text("Skip")
                }

            }
                Text("You got $marks marks")
            }
        }
    } else {
        // Display final marks when all questions are answered
        Text("Your Final Marks: $marks")
    }
}

fun codeForTask(mcq: Mcq, selectedAnswer: Int): List<String> {
    val result = mutableListOf<String>()

    // Check if the selected answer is correct
    val isCorrect = mcq.Answer == selectedAnswer

    // Add the options and correctness status to the result list
    result.addAll(mcq.Options)

    // Add correctness status as the last element
    result.add(if (isCorrect) "Correct!" else "Wrong!")

    // Increment marks based on HardnessLevel
    var marks = mcq.HardnessLevel + 1

    return result
}