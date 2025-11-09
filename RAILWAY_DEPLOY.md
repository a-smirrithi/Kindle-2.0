# 🚀 Railway Deployment Instructions

## IMPORTANT: Database Setup Required

Railway requires manual MySQL database addition. Follow these steps:

### Step 1: Deploy to Railway
1. **Go to [Railway.app](https://railway.app)**
2. **Sign up/Login with GitHub**
3. **Click "New Project"**
4. **Select "Deploy from GitHub repo"**
5. **Choose: `a-smirrithi/Kindle-2.0`**

### Step 2: Add MySQL Database
6. **In your Railway project dashboard:**
   - Click "+" to add a service
   - Select "Database" → "MySQL"
   - Wait for MySQL to deploy

### Step 3: Connect Database
7. **Railway will automatically set these environment variables:**
   - `MYSQLHOST` - Database host
   - `MYSQLPORT` - Database port (usually 3306)
   - `MYSQLDATABASE` - Database name
   - `MYSQLUSER` - Database username
   - `MYSQLPASSWORD` - Database password
   - `DATABASE_URL` - Full connection string

### Step 4: Update Environment Variables (if needed)
8. **Go to your app service → Variables tab**
9. **Ensure these are set:**
   ```
   PORT=8080
   MYSQLUSER=root (or the provided username)
   MYSQLPASSWORD=<your-mysql-password>
   DATABASE_URL=jdbc:mysql://<host>:<port>/<database>?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   ```

### Step 5: Redeploy
10. **Click "Deploy" to restart your application**
11. **Your app will be available at:** `https://your-app-name.railway.app`

## Troubleshooting

If you get database connection errors:
1. Check that MySQL service is running in Railway
2. Verify environment variables are set correctly
3. Redeploy the application

## Expected Result
- ✅ Backend API at: `https://your-app.railway.app/api/books`
- ✅ Frontend at: `https://your-app.railway.app`
- ✅ Automatic table creation on first run
- ✅ Full library management functionality

---

Your Kindle Library Management System will be live and fully functional!