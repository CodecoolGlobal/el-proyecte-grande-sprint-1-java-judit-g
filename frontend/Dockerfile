FROM node:18 AS build

WORKDIR /app

COPY rate-my-driving-instructor-frontend/package*.json ./rate-my-driving-instructor-frontend/

RUN cd rate-my-driving-instructor-frontend && npm install

COPY rate-my-driving-instructor-frontend ./rate-my-driving-instructor-frontend

EXPOSE 3000

CMD ["npm", "run", "dev", "--prefix", "rate-my-driving-instructor-frontend"]
