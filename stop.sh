cd app
mvn clean
cd ..
docker-compose down

docker rm  appmotivacao
docker rm  bancoamotivacao
docker rmi  jose/motivacaojsf
docker rmi  jose/motivacao

