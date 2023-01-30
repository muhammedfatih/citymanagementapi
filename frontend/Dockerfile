# Use node image as base image
FROM node:14

# Set the working directory
WORKDIR /app

# Copy the package.json file
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the application
RUN npm run build

# Use nginx to serve the application
FROM nginx:1.19

# Copy the built application files
COPY --from=0 /app/dist/ /usr/share/nginx/html

# Expose the default nginx port
EXPOSE 80
