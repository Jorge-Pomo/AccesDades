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
        <div>
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
        <div class="enviarBBDD">
            <br>
            <button type="button" class="btn btn-success" onclick="enviarServidor()">Pujar a la BBDD</button>
        </div>
    </main>
    
    <!-- Arrepleguem  l'id que em enviat per get a la URL -->
    <?php
        $name = $_SERVER["HTTP_HOST"] . $_SERVER["REQUEST_URI"];
        $name = substr($name, -1);
    ?>

   <!-- AJvaScript -->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        $id = "<?php echo $name; ?>";

        // Plenar imputs
        axios.get("https://bobsburgers-api.herokuapp.com/characters/" + $id)
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

    <!-- 
        Enviem les dades per POST al servidor on les enviarem a la BBDD. 
    -->
    
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function enviarServidor() {
            let id = document.getElementById('id').value;
            let nom = document.getElementById('nom').value;
            let sexe = document.getElementById('sexe').value;
            let img = document.getElementById('img').src;

            alert(id);
            
            $.ajax({
                url: "store.php",
                data: {
                    id: id,
                    nom: nom,
                    sexe: sexe,
                    img: img
                },
                type: 'POST',
                //dataType: 'html',
                success: function(response) {
                    //$('#contenido').html(data);
                    alert(response);
                }
            });
        }

    </script>

</body>

</html>
