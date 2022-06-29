# Pinkgreen-mkt

---
## How to build and run the project
First you need to build service Docker image
```bash
docker build -f local.dockerfile -t pinkgreen_mkt:latest .
```

Then you run the application service
```bash
docker-compose up -d
```