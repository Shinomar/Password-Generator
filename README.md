# Password-Generator

Ce projet est une application console Java permettant de générer des mots de passe aléatoires et de vérifier leur force.

## Introduction

Lors de mon stage, j'ai été sensibilisé à l'importance cruciale de la sécurité des mots de passe dans le monde numérique actuel. En effet, les cyberattaques sont de plus en plus fréquentes et les mots de passe faibles constituent une porte d'entrée facile pour les pirates informatiques.

C'est pourquoi j'ai décidé de réaliser ce projet de classe sur un générateur de mot de passe. Je trouvais le concept à la fois intéressant et important, et je voulais contribuer à la création d'un outil qui puisse aider les gens à se protéger en ligne.

Ce projet s'articule autour de deux fonctionnalités principales :

Génération de mots de passe aléatoires et sécurisés : l'utilisateur peut choisir les caractères à inclure dans son mot de passe (lettres majuscules et minuscules, chiffres, symboles) et la longueur souhaitée. Le générateur crée ensuite un mot de passe unique et robuste répondant aux exigences de l'utilisateur.
Vérification de la force d'un mot de passe : l'utilisateur peut saisir un mot de passe existant et le générateur évalue sa force en fonction de plusieurs critères (longueur, diversité des caractères, etc.).
Perspectives futures

Je vois plusieurs pistes d'évolution possibles pour ce projet :

Développement d'une interface graphique (GUI) : pour rendre l'outil plus accessible et convivial.
Intégration d'un système d'authentification : pour permettre aux utilisateurs de stocker et de gérer leurs mots de passe de manière sécurisée.
Création d'une API : pour permettre à d'autres développeurs d'intégrer la fonctionnalité de génération de mots de passe dans leurs propres applications.
Je suis convaincu que ce projet a le potentiel d'être un outil utile et précieux pour tous ceux qui se soucient de la sécurité de leurs données en ligne.
## Functionalites

### 1. Génération d'un mot de passe:

- L'utilisateur répond par "Oui" ou "Non" aux questions sur l'utilisation de lettres majuscules, de lettres minuscules, de chiffres ou de symboles.
- L'utilisateur saisit ensuite la longueur souhaitée du mot de passe.
- Un alphabet de mot de passe est généré en fonction des réponses de l'utilisateur, qui est une chaîne contenant les caractères choisis.
- Des caractères aléatoires de l'alphabet du mot de passe sont sélectionnés et combinés pour former une chaîne complètement aléatoire selon les préférences de l'utilisateur.
- Le mot de passe généré aléatoirement est ensuite affiché sur la console.


### 2. Vérification de la force d'un mot de passe :

La vérification de la force est basée sur les critères suivants:
- Le mot de passe utilise des lettres majuscules.
- Le mot de passe utilise des lettres minuscules.
- Le mot de passe utilise des chiffres.
- Le mot de passe utilise des symboles.
- La longueur du mot de passe est de 8 caractères ou plus (8 est souvent la longueur minimale requise pour un mot de passe correct).
- La longueur du mot de passe est de 16 caractères ou plus (16 est considéré comme la longueur minimale pour un bon mot de passe).

Ces critères sont utilisés pour calculer un score pour le mot de passe, qui détermine le message affiché à l'utilisateur indiquant la force du mot de passe (faible/moyen/bon/excellent).

### 3. Affichage d'informations utiles :

Il s'agit d'une fonctionnalité mineure qui affiche des informations à l'utilisateur sur la console concernant la sécurité des mots de passe, telles que d'éviter d'utiliser le même mot de passe deux fois, d'éviter la répétition de caractères, les motifs de clavier, les mots du dictionnaire, les séquences de lettres ou de chiffres, etc.
