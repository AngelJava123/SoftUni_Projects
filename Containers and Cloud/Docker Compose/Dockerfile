FROM node:16

WORKDIR /app

COPY . .

RUN npm install

EXPOSE 8080/tcp

ENTRYPOINT npm run dev