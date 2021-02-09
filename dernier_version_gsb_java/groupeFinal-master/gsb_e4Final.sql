-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 30 Décembre 2020 à 15:24
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsb_e4`
--

-- --------------------------------------------------------

--
-- Structure de la table `exerce`
--

CREATE TABLE `exerce` (
  `V_matricule` int(3) NOT NULL,
  `jjmmaa` datetime NOT NULL,
  `rg_code` int(3) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `exerce`
--

INSERT INTO `exerce` (`V_matricule`, `jjmmaa`, `rg_code`, `role`) VALUES
(12, '2020-09-01 01:00:00', 234, 'vente medoc'),
(3, '2020-09-05 00:00:00', 44, 'oscultation'),
(2, '2020-09-10 00:00:00', 40, 'vente medoc'),
(11, '2020-09-16 17:00:00', 546, 'visite'),
(6, '2020-09-24 11:20:06', 43, 'vente'),
(5, '2020-09-25 03:37:19', 42, 'visit'),
(4, '2020-11-20 10:25:14', 41, 'urgence');

-- --------------------------------------------------------

--
-- Structure de la table `labo`
--

CREATE TABLE `labo` (
  `lb_code` int(3) NOT NULL,
  `lb_nom` varchar(50) NOT NULL,
  `lb_chefvente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `labo`
--

INSERT INTO `labo` (`lb_code`, `lb_nom`, `lb_chefvente`) VALUES
(11, 'Baxter', 'mr erik'),
(12, 'bayer', 'albert finlhand'),
(13, 'biogroup', 'lucien ramon'),
(14, 'Bailly-Creat', 'mr elbaz'),
(15, 'Bailleul', 'mr besnainou'),
(16, 'B Braun Médical', 'mr raoult'),
(17, 'corporation', 'mr kakou');

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `rg_code` int(3) NOT NULL,
  `sc_code` int(3) NOT NULL,
  `rg_nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `region`
--

INSERT INTO `region` (`rg_code`, `sc_code`, `rg_nom`) VALUES
(40, 75, 'montrouge'),
(41, 78, 'versaille'),
(42, 96, 'Champigny sur marne'),
(43, 93, 'seine saint denis'),
(44, 78, 'neuilly sur seine'),
(234, 78, 'lorraine'),
(546, 23, 'ile de france');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `nom_utilisateur` varchar(50) NOT NULL,
  `mots_ de_passe` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`nom_utilisateur`, `mots_ de_passe`) VALUES
('benji', '17052001');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `V_matricule` int(3) NOT NULL,
  `V_nom` varchar(50) NOT NULL,
  `V_prenom` varchar(50) NOT NULL,
  `V_adresse` varchar(50) NOT NULL,
  `V_cp` varchar(50) NOT NULL,
  `V_ville` varchar(50) NOT NULL,
  `V_dateembauche` date NOT NULL,
  `sc_code` int(3) NOT NULL,
  `lb_code` int(3) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `visiteur`
--

INSERT INTO `visiteur` (`V_matricule`, `V_nom`, `V_prenom`, `V_adresse`, `V_cp`, `V_ville`, `V_dateembauche`, `sc_code`, `lb_code`, `image`) VALUES
(2, 'el baz', 'isaac', '6 rue de montreuil', '94 360', 'montreuil', '2020-09-01', 22, 12, ''),
(3, 'burri', 'samuel', '27 avenue de la republique', '75 300', 'paris', '2020-06-30', 72, 13, ''),
(4, 'cohen', 'ruben', '34 rue de flandres', '94 254', 'bobigny', '2020-12-11', 72, 12, ''),
(5, 'toboul', 'avner', '23 avenue de la defense', '78 500', 'paris', '2020-06-08', 78, 13, ''),
(6, 'sellam', 'simon', '61 rue pasteur', '93360', 'neuilly plaisance', '2021-01-08', 93, 12, ''),
(11, 'elbaz', 'david', '64 rue de clichy', '93800', 'perreux', '2020-09-13', 23, 12, ''),
(12, 'besnenou', 'benjamin', '23 rue de la paix', '75024', 'paris', '2020-09-02', 78, 13, '');

-- --------------------------------------------------------

--
-- Structure de la table `zone`
--

CREATE TABLE `zone` (
  `sc_code` int(3) NOT NULL,
  `sc_libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `zone`
--

INSERT INTO `zone` (`sc_code`, `sc_libelle`) VALUES
(22, 'bobigny'),
(23, 'yerres'),
(72, 'rosny'),
(75, 'paris'),
(78, 'leperreux'),
(93, 'nogent'),
(96, 'champigny');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `exerce`
--
ALTER TABLE `exerce`
  ADD PRIMARY KEY (`jjmmaa`),
  ADD KEY `V_matricule` (`V_matricule`),
  ADD KEY `rg_code` (`rg_code`),
  ADD KEY `jjmmaa` (`jjmmaa`),
  ADD KEY `jjmmaa_2` (`jjmmaa`);

--
-- Index pour la table `labo`
--
ALTER TABLE `labo`
  ADD PRIMARY KEY (`lb_code`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`rg_code`),
  ADD KEY `sc_code` (`sc_code`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`nom_utilisateur`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`V_matricule`),
  ADD KEY `sc_code` (`sc_code`),
  ADD KEY `lb_code` (`lb_code`);

--
-- Index pour la table `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`sc_code`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `exerce`
--
ALTER TABLE `exerce`
  ADD CONSTRAINT `exerce_ibfk_1` FOREIGN KEY (`rg_code`) REFERENCES `region` (`rg_code`),
  ADD CONSTRAINT `exerce_ibfk_2` FOREIGN KEY (`V_matricule`) REFERENCES `visiteur` (`V_matricule`);

--
-- Contraintes pour la table `region`
--
ALTER TABLE `region`
  ADD CONSTRAINT `region_ibfk_1` FOREIGN KEY (`sc_code`) REFERENCES `zone` (`sc_code`);

--
-- Contraintes pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD CONSTRAINT `visiteur_ibfk_1` FOREIGN KEY (`sc_code`) REFERENCES `zone` (`sc_code`),
  ADD CONSTRAINT `visiteur_ibfk_2` FOREIGN KEY (`lb_code`) REFERENCES `labo` (`lb_code`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
