# Билд докерфайла делается из папки \docker в проекте
docker build -t meet_room_db .


# Запуск контейнера
docker run -p 5432:5432 --name test_room_db meet_room_db
