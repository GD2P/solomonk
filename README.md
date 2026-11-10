# Solomonk

## Pourquoi ce projet :

Je notais mes séances de musculation dans les notes de mon téléphone : sans date, sans historique, impossible de voir si je progresse. Solomonk sert à enregistrer ce que je fais réellement à la salle (séries, répétitions, charges) pour garder une trace d'une séance à l'autre et, à terme, suivre ma progression.

C'est aussi un projet bac à sable (*sandbox*) : une semaine pour découvrir la stack Spring Boot + Angular + NgRx + PostgreSQL.

## Stack :

- **Base de données** : PostgreSQL 17 (Docker)
- **Backend** : Java 25, Spring Boot, Spring Data JPA
- **Frontend** : Angular + NgRx *(en cours)*
- **Tests d'API** : Bruno (collection dans `bruno/`)

## Lancer le projet :

```bash
docker compose up -d
cd backend
./mvnw spring-boot:run
```

L'API démarre sur `http://localhost:8080`, avec un programme de démonstration chargé automatiquement.

## Sprints

- **Sprint 1 (en cours)** : enregistrer une séance réalisée et la retrouver.
    - API REST (séances types, exercices prévus, création et liste des séances) : fait
    - Frontend Angular + NgRx : à venir
    - Dockerisation complète : à venir
- **Sprint 2 (envisagé)** : authentification, validation des données, migrations Flyway, visualisation de la progression.

Le détail (besoins, user story, modèle de données) est dans [BACKLOG.md](Backlog.md).