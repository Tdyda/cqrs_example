.PHONY: build up stop down restart logs ps prune clean

## Buduje kontenery z Docker Compose
build:
	docker compose up --build -d

## Uruchamia kontenery w tle
up:
	docker compose up -d

## Zatrzymuje działające kontenery
stop:
	docker compose stop

## Zatrzymuje i usuwa kontenery, wolumeny i sieci
down:
	docker compose down -v

## Restartuje kontenery
restart: stop up

## Pokazuje logi ze wszystkich kontenerów
logs:
	docker compose logs -f

## Pokazuje status kontenerów
ps:
	docker compose ps

## Czyści nieużywane zasoby Dockerowe
prune:
	docker system prune -af --volumes

## Usuwa wszystkie kontenery, obrazy i wolumeny (UWAŻAJ!)
clean:
	docker compose down -v --remove-orphans
	docker system prune -af --volumes
