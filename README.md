# Letters Backend

## 구성

- Backend Server
- Kafka
- Zookeeper
- Nginx

## 실행

- 실행

```
docker-compose up -d
```

- 이미 컨테이너와 이미지가 떠있는 경우

```
docker-compose down --rmi all
```

를 실행해서 지워주고 다시 실행하자

- 로그 확인

```
docker-compose logs
```
