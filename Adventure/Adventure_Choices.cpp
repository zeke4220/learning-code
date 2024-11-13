#include <iostream>
#include <array>
#include <string>
#include "Header.h"


std::array<std::string, 5> weapons;
std::array<std::string, 3> Ougi;
int ending_A = 0, ending_B = 0, ending_C = 0, Path_1, Path_2, Path_3, i, k;
std::string weapon, monster, shield, ultimate_attack;
bool reset = 1;
void Adventure_Start() {
    std::string hero_name;
    std::cout << "=============================\n";
    std::cout << "      A Hero's Adventure      \n";
    std::cout << "=============================\n";
    std::cout << "\n";
    std::cout << "\n";
    std::cout << "You are a wandering warrior, roaming from place to place in search of adventure.";
    std::cout << "What is your name: \n";
    std::cin >> hero_name;
}

void Hero_Weapon() {
    std::cout << "==========================================================================\n";
    std::array<std::string, 5> weapons {"Sword", "Spear", "Staff", "Axe", "Dagger"};
    std::cout << "What weapon do you prefer?:\n";
    for (int i = 0; i < 5; i++)
        std::cout << " " << weapons[i] << "\n";
    std::cout << "Please enter your weapon of choice: ";
    std::cin >> weapon;
    std::cout << "You've chosen the " << weapon << " as your weapon of choice!\n";
    std::cout << "==========================================================================\n";
}

void Choice_1() {
    std::cout << "\nYou came to a lone crossroad in an unfimiliar land. You have a choice to make.\n" << "Being in a foreign land all seem perilious to you!\n";
    std::cout << "You see befor you three paths, which do you take?: \n";
    std::cout << "1) The dirt road to the right.\n";
    std::cout << "2) The slightly worn pave path in the middle. \n";
    std::cout << "3) The left path through the woods.\n";


}
void Decision1() {
    std::cin >> Path_1;
    std::cout << "==========================================================================\n";
    if (Path_1 == 1) {
     std::cout << "You decide to go to the right. Although not paved you feel familiarity with dirt roads.\n";
     std::cout << "As you walk you come to a scene of a horrific sight involving a travelling caravan.\n";   
     ending_A++;
    }
    else if (Path_1 == 2) {
     std::cout << "You come to a little, quaint town. You explore this new locale.\n";
     std::cout << "You come accross a villainous scene in progress\n";
     ending_B++;
    }
    else if (Path_1 == 3) {
     std::cout << "Out of the woods, you see before you a vast lake.\n";
     std::cout << "On the shores of the a lake you see a group of murauding pirates pillaging the port.\n";
     ending_C++;
    }
    else {
        std::cout << "Invalid choice, please try again!\n";
        Decision1();
    }
}

void Choice_2() {
    std::cout << "\n";
    std::cout << "==========================================================================\n";
    std::cout << "You ready your " << weapon << " and rush in. You cut and weave your way through the enemies.\n" << "You see what you assume to be the leader and make your way toward it.\n";
    std::cout << "Who is the enemy leader in your sights?:\n";
    std::cout << "1) A Human Bandit that robs and pillage all they come across.\n";
    std::cout << "2) An Orc Warlock that is looking for their next sacrefice for their horrid rituals.\n";
    std::cout << "3) A Hobgoblin looking only to slaughter for excitement.\n";       
    }


void Decision2() {
    std::cin >> Path_2;
    std::cout << "\n";
    std::cout << "==========================================================================\n";
    if (Path_2 == 1) {
        std::cout << "You see the Bandit holding the wealth they've amassed in their hand along with the blood of their victims\n";
        monster = "Bandit", shield = "buckler";
        ending_A++;
    }
    else if (Path_2 == 2) {
        std::cout << "You see the Warlock holding a hostage by the head. They're about to start the incantation for their ritual!\n";
        monster = "Warlock", shield = "barrier";
        ending_B++;
    }
    else if (Path_2 == 3) {
        std::cout << "The Hobgoblin is standing over it's latest victim, it grins as it's about to finish them off!\n";
        monster = "Hobgoblin", shield = "blade";
        ending_C++;
    }
    else {
        std::cout << "Invalid response, please try again!\n";
        Decision2();      
    }
}

void Choice_3() {
    std::cout << "\n";
    std::cout << "==========================================================================\n";
    std::cout << "Your " << weapon << " strikes against the " << monster << "'s " << shield << "\n";
    std::cout << "The " << monster << " looks at you, you now have their full attention!\n";
    std::cout << "Not giving a moment of reprieve to the " << monster << ". You ready your most devestating attack!";
 
}

void Decision3() {
    std::cout << "\n";
    std::cout << "==========================================================================\n";
    std::array<std::string, 3> Ougi{ "Ultima", "Judgement", "Wrath" };
    std::cout << "What is your Ultimate Attack?:\n";
    for (int k = 0; k < 3; k++)
        std::cout << " " << Ougi[k] << "\n";
    std::cout << "Please enter your Ultimate Attack: ";
    std::cin >> ultimate_attack;
    std::cout << "You've chosen " << ultimate_attack << " as your Ultimate Attack!\n";
    std::cout << "As " << ultimate_attack << " hits the " << monster << ".\n";
    std::cout << "The " << monster << " writhe in pain and agony!\n";
}

void Final_choice() {
    std::cout << "\n";
    std::cout << "==========================================================================\n";
    std::cout << "You stand over the " << monster << ". Tired and out of energy.";
    std::cout << "You can see that the " << monster << " is defeated but not yet dead.";
    std::cout << "What do you do with the villian?: \n";
    std::cout << "1) Turn the " << monster << " to the authorities. The people will decide to to do!\n";
    std::cout << "2) Let the " << monster << " go. Maybe they will turn over a new leaf and change!\n";
    std::cout << "3) Kill the " << monster << " right now and there. They don't deserve another chance.\n";
    std::cin >> Path_3;
    if (Path_3 == 1) {
        ending_A = ending_A + 3;
    }
    else if (Path_3 == 2) {
        ending_B = ending_B + 3;
    }
    else if (Path_3 == 3) {
        ending_C = ending_C + 3;
    }
    else {
        std::cout << "Invalid response, please try again!\n";
        Final_choice();
    }
}

void The_End() {
    std::cout << "\n";
    std::cout << "==========================================================================\n";

    if (ending_A > ending_B && ending_A > ending_C) {
        std::cout << "You defeated the " << monster << ". Your deeds were recorded in great detail.\n";
        std::cout << "You were rewarded for your endeavors and continued on your way to your next adventure!\n";
    }
    else if (ending_B > ending_A && ending_B > ending_C) {
        std::cout << "You nearily defeat the " << monster << ". And have showed mercy. You look over your wounds and try to help the rest of the civillian.\n";
        std::cout << "You are met with both gratitudes and criticism from the citizentry for giving " << monster << " mercy!\n";
        std::cout << "After resting for a bit, you are off on your next adventure!\n";
    }
    else if (ending_C > ending_A && ending_C > ending_B) {
        std::cout << "You are greatly injure from your fight with " << monster << ". But you come out victorious.\n";
        std::cout << "You past out from your fight. But the people you save was able to nurse you back to health.\n";
        std::cout << "Even though they don't have much, they compensated you with what they manage to scrounge up.\n";
        std::cout << "After you are well enough to be on your way, you set off on your next adventure\n";
    }
    else {
        std::cout << "You've met your End! Try again!\n";
        Adventure_Start();
    }
}

