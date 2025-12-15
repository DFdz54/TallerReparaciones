DROP DATABASE IF EXISTS tallerrep;
CREATE DATABASE tallerrep CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE tallerrep;

CREATE TABLE usuario (
  id_usuario INT PRIMARY KEY,
  dni VARCHAR(15) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  password VARCHAR(255) NOT NULL,
  rol VARCHAR(50) NOT NULL
);

CREATE TABLE cliente (
  id_cliente INT PRIMARY KEY,
  dni VARCHAR(15) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  telefono VARCHAR(20),
  email VARCHAR(100)
);

CREATE TABLE vehiculo (
  id_vehiculo INT PRIMARY KEY,
  matricula VARCHAR(20) NOT NULL UNIQUE,
  marca VARCHAR(50),
  modelo VARCHAR(50),
  cliente_id INT NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

CREATE TABLE reparacion (
  id_reparacion INT PRIMARY KEY,
  vehiculo_id INT NOT NULL,
  descripcion TEXT,
  fecha_entrada DATE,
  coste_estimado DECIMAL(10,2),
  estado ENUM('pendiente','en curso','finalizada') DEFAULT 'pendiente',
  mecanico_id INT,
  FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id_vehiculo) ON DELETE CASCADE,
  FOREIGN KEY (mecanico_id) REFERENCES usuario(id_usuario) ON DELETE SET NULL
);
