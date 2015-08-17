<!DOCTYPE html>
<html>
<head>
<title>Hello World</title>
</head>

<body>
Hi <?php print htmlspecialchars($_POST['name'], ENT_QUOTES, 'UTF-8'); ?>!

</body>
</html>
