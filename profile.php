<?php
$name = $_GET['name'];
// VULNERABILIDAD: XSS Reflejado
// No se está filtrando la entrada. El atacante puede enviar <script>alert(1)</script>
echo "<h1>Bienvenido, " . $name . "</h1>";
?>