/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Mishel
 * Created: 17/04/2026
 */
CREATE TABLE IF NOT EXISTS `tipo_puesto` (
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `NOMBRE_PUESTO` varchar(60) NOT NULL,
  `SALARIO` DOUBLE NOT NULL,
  PRIMARY KEY (`ID_TIPO_PUESTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;