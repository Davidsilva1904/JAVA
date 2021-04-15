-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Abr-2021 às 12:30
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `musica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `artista` varchar(255) DEFAULT NULL,
  `ano` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `album`
--

INSERT INTO `album` (`id`, `nome`, `artista`, `ano`) VALUES
(1, 'Pratica(mente)', 'Sam The Kid', 2006);

-- --------------------------------------------------------

--
-- Estrutura da tabela `artista`
--

CREATE TABLE `artista` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `pais` varchar(25) NOT NULL,
  `ano` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `artista`
--

INSERT INTO `artista` (`id`, `nome`, `pais`, `ano`) VALUES
(1, 'Sam The Kid', 'Portugal', 1993);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `password` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `nome`, `password`) VALUES
(1, 'David', 'David@123'),
(2, 'Ze', '123'),
(3, 'jorge', '123'),
(4, 'joão', '123');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
