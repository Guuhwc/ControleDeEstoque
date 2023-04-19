SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL,
  `nomeBebida` varchar(40) NOT NULL,
  `lote` varchar(10) NOT NULL,
  `qtd` varchar(10) NOT NULL,
  `validade` varchar(10) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `recebimento` varchar(10) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `estoque` (`id`, `nomeBebida`, `lote`, `qtd`, `validade`, `tipo`, `recebimento`, `preco`) VALUES
(14, 'Whey Protein', 'JK8365', '10', '16/03/2021', 'Suplemento', '12/06/2018', 1000),
(17, 'Coca-Cola', 'FA1601', '10', '16/01/2021', 'Bebida', '12/06/2018', 50),
(23, 'Fanta Uva', 'RG1601', '10', '16/01/2021', 'Bebida', '12/06/2018', 50),
(24, 'Dolly', 'TS0021', '10', '16/01/2021', 'Bebida', '12/06/2018', 50),
(25, 'Sprite', 'XX0000', '10', '16/01/2021', 'Bebida', '12/06/2018', 50),
(26, 'BCAA', 'DS1603', '5', '16/01/2021', 'Pré Treino', '12/06/2018', 80),
(28, 'Água', 'XT9737', '80', '16/01/2021', 'Bebida', '12/06/2018', 70),
(33, 'BCAA', 'DS1603', '5', '16/01/2021', 'Pré Treino', '12/06/2018', 80);

CREATE TABLE `usuario` (
  `id` int(10) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `dataNasc` varchar(20) NOT NULL,
  `privLevel` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `usuario` (`id`, `login`, `senha`, `sexo`, `dataNasc`, `privLevel`, `email`, `telefone`) VALUES
(4, 'Admin', '123456', 'Masculino', '16/01/2000', 99, 'Gus@etec.sp.gov.br', '(11) 9 1234-5678');

ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

ALTER TABLE `estoque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;