# 가치소비 캠페인 API 개발

## 프로젝트 설정

### Docker

#### Docker 실행

```bash
cd campaign
docker-compose up -d
```

#### Docker 정지

```bash
cd project
docker-compose down
```
## 가치소비 API
### 등록
- 화면 : `http://localhost:8080/valueconsumption/form.html`
- API : `POST` `http://localhost:8080/api/v1/value-consumptions`

### 목록
- API : `GET` `http://localhost:8080/api/v1/value-consumptions`

### 조회
- API : `GET` `http://localhost:8080/api/v1/value-consumptions/{id}`