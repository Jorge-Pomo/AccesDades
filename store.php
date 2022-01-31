<?php
    $id = $_POST['id'];
    $nom = $_POST['nom'];
    $sexe = $_POST['sexe'];
    $img = $_POST['img'];

    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "prueba";
    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);

    if (!$conexion) {
        echo "Error en la conexion a MySQL: ".mysqli_connect_error();
        exit();
    }

    $sql = "INSERT INTO personatges (id, nombre, sexo, img) VALUES ('".$id."','".$nom."','".$sexe."','".$img."')";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
    }

    
?>
