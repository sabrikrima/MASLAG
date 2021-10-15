-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 07 oct. 2021 à 20:29
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `maslag_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

DROP TABLE IF EXISTS `coach`;
CREATE TABLE IF NOT EXISTS `coach` (
  `Id_Coach` int(8) NOT NULL,
  `Nom_Coach` varchar(255) NOT NULL,
  `Prenom_Coach` varchar(255) NOT NULL,
  `Id_User` int(8) NOT NULL,
  `Cin_Coach` int(8) NOT NULL,
  `Email_Coach` varchar(255) NOT NULL,
  `Prix_Hr` float NOT NULL,
  PRIMARY KEY (`Id_Coach`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

DROP TABLE IF EXISTS `command`;
CREATE TABLE IF NOT EXISTS `command` (
  `Id_Com` int(8) NOT NULL,
  `Id_Produit` int(8) NOT NULL,
  `Id_User` int(8) NOT NULL,
  `Prix_Produit` double NOT NULL,
  `Date_Com` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Com`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`Id_Com`, `Id_Produit`, `Id_User`, `Prix_Produit`, `Date_Com`) VALUES
(17, 15, 16, 24, '24/01/2009'),
(19, 15, 16, 24, '25/04/2001'),
(1, 1, 1, 1, '1998-12-15'),
(25, 36, 25, 25, '25/17/2001');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `Id_Event` int(8) NOT NULL,
  `Nom_Event` varchar(255) NOT NULL,
  `Adresse_Event` varchar(255) NOT NULL,
  `Num_Event` int(8) NOT NULL,
  `Id_User` int(8) NOT NULL,
  `Prix_P` double NOT NULL,
  `Date_Debut` varchar(255) NOT NULL,
  `Date_Fin` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

DROP TABLE IF EXISTS `exercice`;
CREATE TABLE IF NOT EXISTS `exercice` (
  `Id_Ex` int(8) NOT NULL,
  `Nom_Ex` varchar(255) NOT NULL,
  `Cat_Ex` varchar(255) NOT NULL,
  `Num_Ser` int(2) NOT NULL,
  `Num_Rep` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `Id_Produit` int(8) NOT NULL,
  `Nom_Produit` varchar(255) NOT NULL,
  `Marque_Produit` varchar(255) NOT NULL,
  `Categorie_Produit` varchar(255) NOT NULL,
  `Prix_Produit` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `Id_User` int(11) NOT NULL,
  `Nom_User` varchar(255) NOT NULL,
  `Prenom_User` varchar(255) NOT NULL,
  `Email_User` varchar(255) NOT NULL,
  `Cin_User` int(8) NOT NULL,
  `Num_User` int(8) NOT NULL,
  `Adresse_User` varchar(255) NOT NULL,
  `Date_N_User` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
