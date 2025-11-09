# 🚀 Railway Deployment Instructions

## Quick Deploy to Railway

1. **Fork/Clone this repository**
2. **Go to [Railway.app](https://railway.app)**
3. **Sign up/Login with GitHub**
4. **Click "New Project"**
5. **Select "Deploy from GitHub repo"**
6. **Choose your fork of this repository**
7. **Railway will automatically:**
   - Detect it's a Java/Spring Boot app
   - Provision a MySQL database
   - Set environment variables
   - Build and deploy your application

## Environment Variables (Auto-configured by Railway)

Railway automatically provides:
- `DATABASE_URL` - MySQL connection string
- `DB_USERNAME` - Database username
- `DB_PASSWORD` - Database password  
- `PORT` - Application port (usually 8080)

## Post-Deployment

1. **Your app will be available at:** `https://your-app-name.railway.app`
2. **Database will be automatically created and connected**
3. **All tables will be created on first run**
4. **Ready to use!**

## Custom Domain (Optional)

1. Go to your Railway project settings
2. Click on "Domains"
3. Add your custom domain
4. Update DNS records as instructed

---

Your Kindle Library Management System will be live and fully functional on Railway!