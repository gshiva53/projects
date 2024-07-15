# Portfolio Inspirations
1. [brittanychang.com](https://v3.brittanychiang.com/) - Website format | Project technologies | website font | Skills 
2. [lokkeestudios.com](https://www.lokkeestudios.com/) - Check out the ‘HitMeUp’ Section and ‘SourceCode’ section. 
3. [wassim.dev](https://wassim.dev/) - Logo | Potrait picture | Simplistic design
4. [bradfrost.com](https://bradfrost.com/)- Vertical navigation | simplistic theme /background with simple hover logic
5. [lynnandtonic.com](https://lynnandtonic.com/) - Projects section. Clean UI with project URLs. 
6. [sarasoueidan.com](https://www.sarasoueidan.com/) - Logo | Signature

*References taken from the article: [web-developer-portfolio-examples](https://alvarotrigo.com/blog/web-developer-portfolio-examples/)*

# Portfolio Tasks
- [ ] Add a font. 
- [ ] Explore coloured themes. (example: black and green color)
- [ ] Add emojis and/or icons. (resources: Font Awesome, Feather, Octicons)
- [ ] Align the skills unordered lists with the border. 
- [ ] Footer
- [ ] Give credit to the portfolio inspirations. 
- [ ] Projects section
- [ ] Add a resume pdf to the website. 
- [ ] Contact through email section. 
- [ ] Social Media Links
- [ ] Profile Picture?

# Linode Server Setup and Website Deployment
## 1. Basic Server Setup
1. SSH into the server. 
2. Set the time zone. 
3. Add a new user. 
4. Add this new user to the `sudo` group. 
5. Login using the new user, in this case, the new user is `shiva`.
6. Delete the password for the root user. 
7. Lock the password for the root user. 

## 2. Configure Nginx
1. Install nginx.
2. Create a new dir at this path: `/var/www/139.144.99.189`
3. Change the privileges of the dir so everyone can access them using `chmod`
4. Change the owner of the dir to `shiva` using `chown`
5. Create an nginx file. 
6. Create a link for the config file to newly created nginx file.
7. Restart nginx.

## 3. Create a deploy shell script
```sh
echo "Switching to branch main"
git checkout main

echo "building app..."
npm run build
  

echo "Deploying files to Server"
scp -r dist/portfolio-website/* shiva@139.144.99.189:/var/www/139.144.99.189/

echo "Done!"
```


## 4. Deploy to the server
1. cd into git dir
2. Run the script
3. Navigate to the `139.144.99.189` address and the website should be up and running.


