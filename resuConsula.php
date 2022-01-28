<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bob's Burger Characters</title>
    
    <link rel="stylesheet" href="./css/index.css">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
   <header>
       <h1 class="centrarText">Bob's Burger Characters</h1>
       <img class="portada" src="https://pics.filmaffinity.com/Bob_s_Burgers_Serie_de_TV-894552775-large.jpg" alt="">
   </header>
    <main>
        <div >
            <label for="" class="col-sm-2 col-form-label">Id: </label>
            <input type="text" class="form-control" id="id">
        </div>
        <div>
            <label for="" class="col-sm-2 col-form-label">Nom: </label>
            <input type="text" class="form-control" id="nom">
        </div>
        <div>
            <label for="" class="col-sm-2 col-form-label">Sexe: </label>
            <input type="text" class="form-control" id="sexe">
        </div>
        <div>
            <label for="" class="col-sm-2 col-form-label">Imatge: </label>
            <img src="" alt="imatge" id="img">
        </div>
    </main>
    
    <?php
        $name = $_SERVER["HTTP_HOST"] . $_SERVER["REQUEST_URI"];
        $name = substr($name, -1);
    ?>
    
    <script src = "https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        $id = "<?php echo $name; ?>" ;
        
        // Plenar imputs
        axios.get("https://bobsburgers-api.herokuapp.com/characters/"+$id)
                .then(response => {
                    console.log(response.data);
                    document.getElementById('id').value = response.data.id;
                    document.getElementById('nom').value = response.data.name; 
                    document.getElementById('sexe').value = response.data.gender; 
                    document.getElementById('img').src = response.data.image; 
                })
        .catch(error => {
            console.error(error);
        });
    </script>
    
    <!-- Enviar al servidor -->
        <?php
                $id = "<script>document.getElementById('id').value;</script>";
                $nombre = "<script>document.getElementById('nom').value;</script>";
                $sexo = "<script>document.getElementById('sexe').value;</script>";
                $img = "<script>document.getElementById('img').value;</script>";
                $servidor = "localhost";
                $usuario = "root";
                $password = "";
                $dbname = "prueba";
                $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
                if (!$conexion) {
                    
                    echo "Error en la conexion a MySQL: ".mysqli_connect_error();
                    exit();
                }
                
                $sql = "INSERT INTO `personatges`(`id`, `nombre`, `sexo`, `img`) VALUES ('". $id ."','". $nombre ."','". $sexo ."','". $img ."')";
                if (mysqli_query($conexion, $sql)) {
                    
                    echo "Registro insertado correctamente.";
                } else {
                    
                    echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
                }
            
        ?>
    
</body>
</html>