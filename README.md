# 📚 Application de Gestion Scolaire - Spring Boot & Thymeleaf

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)](https://spring.io/projects/spring-boot)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-blue)](https://www.thymeleaf.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple)](https://getbootstrap.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 📋 Table des Matières
- [Aperçu](#-aperçu)
- [Fonctionnalités](#-fonctionnalités)
- [Technologies](#-technologies)
- [Installation](#-installation)
- [Structure du Projet](#-structure-du-projet)
- [Modèle de Données](#-modèle-de-données)
- [Captures d'écran](#-captures-décran)
- [API Endpoints](#-api-endpoints)
- [Fonctionnalités Avancées](#-fonctionnalités-avancées)
- [Développement](#-développement)
- [Auteur](#-auteur)
- [Licence](#-licence)

---

## 🎯 Aperçu

Application web complète de gestion scolaire développée avec **Spring Boot**, **Thymeleaf** et **Bootstrap**. Cette plateforme permet aux administrateurs scolaires de gérer efficacement les étudiants, les filières, les cours et les dossiers administratifs dans un environnement moderne et intuitif.

**Objectifs principaux :**
- Centraliser la gestion des données scolaires
- Automatiser les processus administratifs
- Fournir une interface utilisateur intuitive et responsive
- Générer automatiquement les documents administratifs

---

## ✨ Fonctionnalités

### ✅ **Gestion des Élèves**
- **CRUD complet** (Créer, Lire, Mettre à jour, Supprimer)
- Affectation automatique à une filière
- Inscription à plusieurs cours simultanément
- Génération automatique du dossier administratif
- Détails complets avec filière, cours et dossier

### ✅ **Gestion des Filières**
- Création et gestion des programmes académiques
- Visualisation des statistiques par filière
- Association des cours aux filières
- Liste des élèves par filière

### ✅ **Gestion des Cours**
- Catalogue complet des matières enseignées
- Rattachement aux filières appropriées
- Gestion des inscriptions des élèves
- Interface de recherche et filtrage

### ✅ **Fonctionnalités Spéciales**
- **Numéro d'inscription automatique** (format: FILIERE-ANNEE-ID)
- **Dossier administratif auto-généré** à la création d'un élève
- **Interface responsive** adaptée à tous les appareils
- **Recherche en temps réel** dans les listes
- **Design moderne** avec Bootstrap 5.3

---

## 🛠️ Technologies

### **Backend**
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistance des données
- **Spring MVC** - Architecture Model-View-Controller
- **H2 Database** - Base de données en mémoire (développement)
- **Lombok** - Réduction du code boilerplate
- **Maven** - Gestion des dépendances

### **Frontend**
- **Thymeleaf** - Moteur de templates côté serveur
- **Bootstrap 5.3** - Framework CSS/JS
- **HTML5 / CSS3** - Structure et style
- **JavaScript** - Interactivité côté client
- **Bootstrap Icons** - Bibliothèque d'icônes

### **Outils de Développement**
- **IntelliJ IDEA / VS Code** - IDE
- **Git / GitHub** - Contrôle de version
- **Postman** - Tests API (optionnel)
- **H2 Console** - Administration de la base

---

## 🚀 Installation

### **Prérequis**
- Java 17 ou supérieur
- Maven 3.6+
- IDE recommandé: IntelliJ IDEA ou VS Code

### **Étapes d'installation**

```bash
# 1. Cloner le projet
git clone https://github.com/Arib61/Spring_Boot_Thymeleaf.git
cd Spring_Boot_Thymeleaf

# 2. Compiler le projet
mvn clean install

# 3. Lancer l'application
mvn spring-boot:run

# 4. Accéder à l'application
# Naviguez vers http://localhost:8080
