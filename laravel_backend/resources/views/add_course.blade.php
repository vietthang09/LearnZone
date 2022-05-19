<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Add course</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <form method="POST" action="/add-course">
            @csrf
            <strong>Title</strong>
            <input type="text" name="title">
            <strong>Description</strong>
            <input type="text" name="description">
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
