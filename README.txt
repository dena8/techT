# techT

Условие на задачата:
Направете команден интерпретатор на Java. Програмата да работи като конзолно
приложение. Дизайнът може да се състои от поле за писане на командите и поле, в което
да се визуализира изхода от командата. Командите са: reverse, count-words, set, get, load,
save, exit. Програмата да очаква въвеждането на команди докато не се въведе exit.
set - приема 2 аргумента, име и стойност. Трябва да създадете структура, която да
използвате за съхраняване на данни. Трябва да съхраните стройността от командата
(втория аргумент) зад ключ с име, подаден като първи аргумент. Нека ключа и стойността
да се съхраняват като низове. Ако вече има запазена стойност зад съответния ключ, нека
стойността бъде презаписана.
Вход:
set myCoolVar 45
Изход:
Saved myCoolVar = 45

get - приема един аргумент. Връща стойност, запазена в съответната структура от
командата set. Ако няма такава стойност да изведе на конзолата съобщение за грешка.
Вход:
get myCoolVar
Изход:
myCoolVar = 45

Вход:
Get someName
Изход:
Err: no value for someName

load - приема един аргумент - име на файл. Във файла данните за всеки ред са в следния
формат [key]=[value].Всяка двойка данни се запаметява, подобно на командата set. Всяка двойка е на нов ред.
Данните, запазени чрез load трябва да може да бъдат достъпвани чрез get и save.
Вход: Изход
load data.txt
Изход:
Data from data.txt is loaded

save - приема един аргумент - име на файл. Всички запаметени чрез set или load
ключ-стойности двойки се запазват във файл в следния формат:[key]=[value]
Всяка двойка данни е на нов ред.
Вход:
save dump.txt
Изход:
Data exported to dump.txt

exit - не приема аргументи, спира изпълнението на програмата

Бонус команди:
reverse - приема неопределен брой аргументи,които се разглеждат като едно цяло
изречение/фраза и обръща символите в обратен ред
Вход:
reverse Walltopia the best!
Изход:
!tseb eht aipotllaW

count-words - приема един аргумент - име на файл, и извежда на конзолата броя на
думите в него. За дума се приема всяка група от символи, разделени от един или няколко
интервала
Вход:
count-words test.txt
Изход:
Words in test.txt: 241
При въвеждане на несъществуваща команда да се изведе съобщение за грешка, и да се
очаква да се приеме следваща команда.

Пояснения:
Направете така структурата на програмата, че да е възможно във всеки един момент
бързо и лесно да бъдат добавяни нови команди. Ако имате възможност направете така, че
всяка команда да може да се изпълнява паралелно с другите (върху различни нишки).
Внимателно подберете структурата, в която ще съхранявате данните, съобразете се с
условието за паралелното изпълнение на командите от различни нишки.
Примерна работа на програмата:
get name
Err: no value for name
set aliens exist
Saved aliens=exist
set name Mitko
Saved name=Mitko
get name
name=Mitko
load data.txt
Data from data.txt is loaded
get name
name=Ivan
get family
family=Ivanov
set family Nikolov
Saved family=Nikolov
save output.txt
Data exported to output.txt
exit
