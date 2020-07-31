-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2016 a las 00:25:00
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumbrado`
--

CREATE TABLE `alumbrado` (
  `id_alum` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `montpg` double NOT NULL,
  `pago` double NOT NULL,
  `cambio` double NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumbrado`
--

INSERT INTO `alumbrado` (`id_alum`, `nombre`, `calle`, `montpg`, `pago`, `cambio`, `hora`, `fecha`) VALUES
(1, 'Alonso', 'San Martin', 50, 100, 50, '8 pm', '2016-10-16'),
(2, 'Agustin Mena', 'Santa Lucia Tecamac', 50, 100, 50, '6:09 pm', '0000-00-00'),
(3, 'Arturo Trejo', 'San Martin Tecamac', 50, 100, 50, '8:47 pm', '2016-12-03'),
(4, 'Arturo Trejo Rodriguez', 'San Pedro La Laguna', 100, 200, 100, '9 pm', '2016-12-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `fecha_evento` date NOT NULL,
  `hora_inicio` varchar(10) NOT NULL,
  `hora_termino` varchar(10) NOT NULL,
  `montpg` double NOT NULL,
  `pago` double NOT NULL,
  `cambio` double NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id_evento`, `nombre`, `direccion`, `fecha_evento`, `hora_inicio`, `hora_termino`, `montpg`, `pago`, `cambio`, `hora`, `fecha`) VALUES
(1, 'Aruro', 'San Pablo', '2016-10-16', '1 pm', '2 am', 200, 300, 300, '9 pm', '2016-10-08'),
(2, 'arturo', 'xolox', '2016-12-10', '1 am', '9 pm', 200, 200, 0, '1 pm', '2016-12-04'),
(3, 'elia santiago colina', 'pachuca 27 ejidos de tecamac', '2016-12-09', '8:00AM', '10:00 AM', 200, 900, 700, '7:00 PM', '2016-12-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nvatoma`
--

CREATE TABLE `nvatoma` (
  `id_nuvatoma` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `calle2` varchar(50) NOT NULL,
  `calle3` varchar(50) NOT NULL,
  `montpg` double NOT NULL,
  `pago` double NOT NULL,
  `cambio` double NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nvatoma`
--

INSERT INTO `nvatoma` (`id_nuvatoma`, `nombre`, `calle`, `calle2`, `calle3`, `montpg`, `pago`, `cambio`, `hora`, `fecha`) VALUES
(1, 'Arturo', 'Santa Lucia', 'San Juan', 'San Pedro', 2000, 3000, 1000, '8 pm', '2015-07-15'),
(2, 'Pancho', 'Santa Lucia', 'San Juan', 'San Pedro', 2000, 3000, 1000, '8 pm', '2015-07-15'),
(3, 'Arturo Trejo', 'San Martin', 'Tecamac', 'San Lucas', 3000, 20000, 17000, '8 pm', '2016-12-02'),
(4, 'Artuto Trejo Rodriguez', 'San Martin Tecamac', 'San Martin Tecamac', 'San Martin Tecamac', 5000, 20000, 15000, '2 pm', '2016-12-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `id_puest` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `montpg` double NOT NULL,
  `pago` double NOT NULL,
  `cambio` double NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`id_puest`, `nombre`, `producto`, `montpg`, `pago`, `cambio`, `hora`, `fecha`) VALUES
(1, 'Arturo', 'papas', 15, 30, 15, '8 pm', '2016-10-06'),
(2, 'Arturo', 'Papas', 90, 200, 110, '8 pm', '2016-12-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tomaagua`
--

CREATE TABLE `tomaagua` (
  `id_toma` int(11) NOT NULL,
  `no_toma` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `montpg` double NOT NULL,
  `pago` double NOT NULL,
  `cambio` double NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tomaagua`
--

INSERT INTO `tomaagua` (`id_toma`, `no_toma`, `nombre`, `calle`, `montpg`, `pago`, `cambio`, `hora`, `fecha`) VALUES
(1, '123', 'Arturo', 'Santa Lucia', 123, 456, 789, '8 pm', '2016-10-16'),
(2, 'toma', 'Gabriel', 'San Pedro', 200, 500, 300, '10 pm', '2016-07-16'),
(3, 'tom', 'Gabriel', 'San Pedro', 200, 500, 300, '10 pm', '2016-07-16'),
(4, '123f', 'aaa', 'ffff', 100, 200, 100, '10 pm', '2016-12-02'),
(5, '12344', 'Arturo Trejo Rodriguez', 'San Jose De La Villa', 100, 200, 100, '7:37 am', '2016-12-02'),
(6, '125a', 'Arturo Trejo', 'San Pablo', 100, 100, 0, '12 pm', '2016-12-07'),
(7, '129363852ABC', 'Arturo Trejo Rodríguez', 'Av. Santa Lucia, Zumpango', 100, 200, 100, '1:56 pm', '2016-12-04');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumbrado`
--
ALTER TABLE `alumbrado`
  ADD PRIMARY KEY (`id_alum`);

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`);

--
-- Indices de la tabla `nvatoma`
--
ALTER TABLE `nvatoma`
  ADD PRIMARY KEY (`id_nuvatoma`);

--
-- Indices de la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`id_puest`);

--
-- Indices de la tabla `tomaagua`
--
ALTER TABLE `tomaagua`
  ADD PRIMARY KEY (`id_toma`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumbrado`
--
ALTER TABLE `alumbrado`
  MODIFY `id_alum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `nvatoma`
--
ALTER TABLE `nvatoma`
  MODIFY `id_nuvatoma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `puesto`
--
ALTER TABLE `puesto`
  MODIFY `id_puest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tomaagua`
--
ALTER TABLE `tomaagua`
  MODIFY `id_toma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
