-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 04-12-2023 a las 06:45:55
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_final_algoritmo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `RUC` bigint(20) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Sede` varchar(255) NOT NULL,
  `NumeroContacto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Correo` varchar(255) DEFAULT NULL,
  `NumeroContacto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellido`, `Correo`, `NumeroContacto`) VALUES
(12345698, 'Olivia Jane', 'Davis Garcia', 'olivia.davis@hotmail.com', '927234567'),
(23456789, 'Mia Grace', 'Martinez Jones', 'mia.martinez@gmail.com', '920678901'),
(32476189, 'Michael Thomas', 'Wilson Davis', 'michael.wilson@hotmail.com', '923789012'),
(45678932, 'Liam Joseph', 'Davis Moore', 'liam.davis@hotmail.com', '924123456'),
(54321987, 'Ella Sophia', 'Wilson Miller', 'ella.wilson@gmail.com', '926234567'),
(54892370, 'Emily Rose', 'Martinez Anderson', 'emily.martinez@hotmail.com', '924890123'),
(65432198, 'Ava Marie', 'Johnson Harris', 'ava.johnson@hotmail.com', '923012345'),
(72741307, 'John Michael', 'Smith Doe', 'john.smith@gmail.com', '920134567'),
(76543282, 'Benjamin David', 'Johnson Scott', 'benjamin.johnson@gmail.com', '927345678'),
(76543289, 'James Robert', 'Johnson Wilson', 'james.johnson@gmail.com', '926012345'),
(78965432, 'Sophia Elizabeth', 'Wilson Brown', 'sophia.wilson@gmail.com', '929567890'),
(87654321, 'Daniel William', 'Anderson Taylor', 'daniel.anderson@hotmail.com', '928345678'),
(98563201, 'Alice Anne', 'Johnson Brown', 'alice.johnson@gmail.com', '921456789'),
(98765432, 'William Henry', 'Taylor Lee', 'william.taylor@hotmail.com', '921890123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concesion`
--

CREATE TABLE `concesion` (
  `CodigoProducto` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255) NOT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `concesion`
--

INSERT INTO `concesion` (`CodigoProducto`, `Nombre`, `Descripcion`, `Precio`, `Stock`) VALUES
(1, 'Palomitas de Maíz', 'Bolsa grande de palomitas', 5.99, 100),
(2, 'Refresco Grande', 'Refresco de cola grande', 3.50, 150),
(3, 'Combo Palomitas y Refresco', 'Bolsa de palomitas + Refresco mediano', 8.99, 80),
(4, 'Nachos con Queso', 'Nachos con salsa de queso', 4.75, 120),
(5, 'Hot Dog', 'Perro caliente con pan y aderezos', 6.25, 100),
(6, 'Helado', 'Tarrina de helado', 3.99, 80),
(7, 'Chocolate', 'Barra de chocolate', 2.50, 200),
(8, 'Galletas', 'Paquete de galletas', 1.99, 150),
(9, 'Café', 'Taza de café', 2.75, 100),
(10, 'Agua embotellada', 'Botella de agua mineral', 1.50, 200),
(11, 'Combo Familiar', 'Palomitas familiares + 4 refrescos grandes', 16.99, 50),
(12, 'Donas', 'Caja de donas surtidas', 5.25, 80),
(13, 'Nachos con Guacamole', 'Nachos con salsa de guacamole', 5.99, 90),
(14, 'Pizza Individual', 'Pizza personal de queso', 7.50, 70),
(15, 'Hamburguesa', 'Hamburguesa clásica', 8.99, 60),
(16, 'Pollo Frito', 'Pieza de pollo frito', 4.25, 100),
(17, 'Ensalada César', 'Ensalada César con aderezo', 6.75, 40),
(18, 'Sushi Combo', 'Combo de sushi variado', 9.99, 30),
(19, 'Tacos de Carnitas', 'Tacos de carnitas con salsa', 7.25, 50),
(20, 'Smoothie de Frutas', 'Batido de frutas frescas', 4.99, 60),
(21, 'Papas Fritas', 'Bolsa de papas fritas', 3.25, 120),
(22, 'Cerveza', 'Botella de cerveza nacional', 5.50, 80),
(23, 'Vino Tinto', 'Botella de vino tinto', 12.99, 40),
(24, 'Helado Sundae', 'Sundae de helado con toppings', 6.99, 70),
(25, 'Pretzels', 'Pretzels salados', 2.75, 100),
(26, 'Algodón de Azúcar', 'Algodón de azúcar en barra', 1.99, 150),
(27, 'Sandwich de Pollo', 'Sandwich de pollo a la parrilla', 5.75, 60),
(28, 'Muffin de Arándanos', 'Muffin con arándanos', 3.25, 90),
(29, 'Malteada', 'Malteada de vainilla', 4.50, 80),
(30, 'Té Helado', 'Té helado con limón', 2.99, 120),
(31, 'Tacos de Pescado', 'Tacos de pescado con salsa de mango', 8.25, 50),
(32, 'Sopa del Día', 'Sopa casera del día', 4.99, 40),
(33, 'Empanadas', 'Empanadas de carne', 3.75, 70),
(34, 'Rollitos de Primavera', 'Rollitos de primavera con salsa agridulce', 5.50, 60),
(35, 'Churros', 'Churros con azúcar y canela', 2.25, 100),
(36, 'Pastel de Chocolate', 'Porción de pastel de chocolate', 4.75, 40),
(37, 'Aros de Cebolla', 'Aros de cebolla crujientes', 3.50, 80),
(38, 'Batatas Fritas', 'Batatas fritas con salsa de queso', 5.25, 50),
(39, 'Pastelitos', 'Pastelitos variados', 2.99, 120),
(40, 'Tiramisú', 'Porción de tiramisú', 6.50, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `CodigoEmpleado` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Sueldo` decimal(10,2) NOT NULL,
  `Telefono` varchar(255) NOT NULL,
  `Cargo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`CodigoEmpleado`, `Nombre`, `Apellido`, `Sueldo`, `Telefono`, `Cargo`) VALUES
(1, 'Juan', 'Perez', 30000.00, '928323053', 'Asistente'),
(2, 'Maria', 'Gomez', 35000.50, '928456789', 'Cajero'),
(3, 'Carlos', 'Lopez', 28000.75, '928987654', 'Recepcionista'),
(4, 'Ana', 'Rodriguez', 32000.25, '928111222', 'Supervisor'),
(5, 'Laura', 'Martinez', 30000.00, '928333444', 'Asistente'),
(6, 'Pedro', 'Diaz', 35000.50, '928555666', 'Cajero'),
(7, 'Sofia', 'Hernandez', 28000.75, '928777888', 'Recepcionista'),
(8, 'David', 'Torres', 32000.25, '928999000', 'Supervisor'),
(9, 'Marta', 'Ruiz', 30000.00, '928123456', 'Asistente'),
(10, 'Javier', 'Gonzalez', 35000.50, '928234567', 'Cajero'),
(11, 'Paula', 'Sanchez', 28000.75, '928345678', 'Recepcionista'),
(12, 'Roberto', 'Jimenez', 32000.25, '928456789', 'Supervisor'),
(13, 'Carmen', 'Fernandez', 30000.00, '928567890', 'Asistente'),
(14, 'Daniel', 'Ramirez', 35000.50, '928678901', 'Cajero'),
(15, 'Isabel', 'Luna', 28000.75, '928789012', 'Recepcionista'),
(16, 'Alejandro', 'Vega', 32000.25, '928890123', 'Supervisor'),
(17, 'Elena', 'Torres', 30000.00, '928901234', 'Asistente'),
(18, 'Francisco', 'Navarro', 35000.50, '928012345', 'Cajero'),
(19, 'Sara', 'Molina', 28000.75, '928123456', 'Recepcionista'),
(20, 'Antonio', 'Garcia', 32000.25, '928234567', 'Supervisor'),
(21, 'Beatriz', 'Ortega', 30000.00, '928345678', 'Asistente'),
(22, 'Adrian', 'Herrera', 35000.50, '928456789', 'Cajero'),
(23, 'Natalia', 'Perez', 28000.75, '928567890', 'Recepcionista'),
(24, 'Hugo', 'Cruz', 32000.25, '928678901', 'Supervisor'),
(25, 'Luisa', 'Gutierrez', 30000.00, '928789012', 'Asistente'),
(26, 'Raul', 'Santos', 35000.50, '928890123', 'Cajero'),
(27, 'Monica', 'Reyes', 28000.75, '928901234', 'Recepcionista'),
(28, 'Gabriel', 'Fuentes', 32000.25, '928012345', 'Supervisor'),
(29, 'Lorena', 'Castro', 30000.00, '928123456', 'Asistente'),
(30, 'Eduardo', 'Moreno', 35000.50, '928234567', 'Cajero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenconcesion`
--

CREATE TABLE `ordenconcesion` (
  `NumeroOrden` int(11) NOT NULL,
  `NombreCliente` varchar(100) NOT NULL,
  `Producto` varchar(100) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioUnitario` decimal(10,2) NOT NULL,
  `Total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ordenconcesion`
--

INSERT INTO `ordenconcesion` (`NumeroOrden`, `NombreCliente`, `Producto`, `Cantidad`, `PrecioUnitario`, `Total`) VALUES
(1, 'Ana López', 'Palomitas', 2, 5.00, 10.00),
(2, 'Juan Martínez', 'Refresco', 1, 3.00, 3.00),
(3, 'María García', 'Hot Dog', 3, 4.50, 13.50),
(4, 'Carlos Rodríguez', 'Nachos', 2, 6.00, 12.00),
(5, 'Laura Fernández', 'Coca-Cola', 2, 2.50, 5.00),
(6, 'Javier Pérez', 'Galletas', 1, 3.00, 3.00),
(7, 'Sofía Gómez', 'Palomitas', 3, 5.00, 15.00),
(8, 'Pedro Sánchez', 'Refresco', 2, 3.00, 6.00),
(9, 'Carmen Torres', 'Hot Dog', 1, 4.50, 4.50),
(10, 'Alejandro Díaz', 'Nachos', 2, 6.00, 12.00),
(11, 'Isabel Ruiz', 'Coca-Cola', 1, 2.50, 2.50),
(12, 'Miguel López', 'Galletas', 2, 3.00, 6.00),
(13, 'Elena Martínez', 'Palomitas', 2, 5.00, 10.00),
(14, 'Antonio García', 'Refresco', 3, 3.00, 9.00),
(15, 'Beatriz Rodríguez', 'Hot Dog', 1, 4.50, 4.50),
(16, 'Daniel Fernández', 'Nachos', 2, 6.00, 12.00),
(17, 'Lucía Pérez', 'Coca-Cola', 2, 2.50, 5.00),
(18, 'Francisco Gómez', 'Galletas', 1, 3.00, 3.00),
(19, 'Cristina Sánchez', 'Palomitas', 3, 5.00, 15.00),
(20, 'Roberto Torres', 'Refresco', 1, 3.00, 3.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `CodigoPelicula` int(11) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `Director` varchar(255) NOT NULL,
  `Genero` varchar(255) DEFAULT NULL,
  `Duracion` int(11) NOT NULL,
  `ClasificacionEdad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`CodigoPelicula`, `Titulo`, `Director`, `Genero`, `Duracion`, `ClasificacionEdad`) VALUES
(1, 'Titanic', 'James Cameron', 'Romance', 195, '+14'),
(2, 'Sueño de Fuga', 'Frank Darabont', 'Drama', 142, '+18'),
(3, 'Origen', 'Christopher Nolan', 'Ciencia Ficción', 148, '+14'),
(4, 'Pulp Fiction', 'Quentin Tarantino', 'Crimen', 154, '+18'),
(5, 'Parque Jurásico', 'Steven Spielberg', 'Aventura', 127, '+14'),
(6, 'El Señor de los Anillos: La Comunidad del Anillo', 'Peter Jackson', 'Fantasía', 178, '+14'),
(7, 'Forrest Gump', 'Robert Zemeckis', 'Drama', 142, '+14'),
(8, 'El Caballero de la Noche', 'Christopher Nolan', 'Acción', 152, '+14'),
(9, 'Matrix', 'The Wachowskis', 'Ciencia Ficción', 136, '+18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `NumeroSala` int(11) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `TipoSala` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`NumeroSala`, `Capacidad`, `TipoSala`) VALUES
(1, 100, '2D'),
(2, 120, '3D'),
(3, 80, 'D-BOX'),
(4, 150, '2D'),
(5, 110, '3D'),
(6, 90, 'D-BOX'),
(7, 130, '2D'),
(8, 95, '3D'),
(9, 75, 'D-BOX'),
(10, 140, '2D'),
(11, 105, '3D'),
(12, 85, 'D-BOX'),
(13, 125, '2D'),
(14, 100, '3D'),
(15, 70, 'D-BOX'),
(16, 110, '2D'),
(17, 80, '3D'),
(18, 120, 'D-BOX'),
(19, 95, '2D'),
(20, 130, '3D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Usuario` varchar(100) NOT NULL,
  `Contraseña` varchar(100) NOT NULL,
  `Rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Usuario`, `Contraseña`, `Rol`) VALUES
('Abner', '0123', 'Empleado'),
('Pierre', '1234', 'Administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`RUC`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `concesion`
--
ALTER TABLE `concesion`
  ADD PRIMARY KEY (`CodigoProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`CodigoEmpleado`);

--
-- Indices de la tabla `ordenconcesion`
--
ALTER TABLE `ordenconcesion`
  ADD PRIMARY KEY (`NumeroOrden`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`CodigoPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`NumeroSala`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `CodigoPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
