echo "Switching to branch main" 
git checkout main

echo "building app..." 
npm run build 

echo "Deploying build files to Server" 
scp -r dist/portfolio-website/* shiva@139.144.99.189:/var/www/139.144.99.189/

echo "Deploying nginx file to Server" 
scp -r 139.144.99.189 shiva@139.144.99.189:/etc/nginx/sites-enabled/139.144.99.189

echo "Done!"