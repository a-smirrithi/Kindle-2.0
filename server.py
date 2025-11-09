#!/usr/bin/env python3
"""
Simple HTTP Server for Kindle 2.0 Frontend
Serves the frontend on localhost with proper CORS headers
"""

import http.server
import socketserver
import os
import webbrowser
from urllib.parse import urlparse

PORT = 3000

class CORSRequestHandler(http.server.SimpleHTTPRequestHandler):
    def end_headers(self):
        self.send_header('Access-Control-Allow-Origin', '*')
        self.send_header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')
        self.send_header('Access-Control-Allow-Headers', 'Content-Type')
        super().end_headers()
    
    def do_OPTIONS(self):
        self.send_response(200)
        self.end_headers()

def start_server():
    # Change to the directory containing index.html
    os.chdir(os.path.dirname(os.path.abspath(__file__)))
    
    with socketserver.TCPServer(("", PORT), CORSRequestHandler) as httpd:
        print(f"""
🚀 Kindle 2.0 Frontend Server Started!
📱 Frontend URL: http://localhost:{PORT}
🔗 Direct link: http://localhost:{PORT}/

👨‍💻 Make sure backend is running on http://localhost:8080

Press Ctrl+C to stop the server
        """)
        
        try:
            httpd.serve_forever()
        except KeyboardInterrupt:
            print("\n🛑 Server stopped!")
            httpd.shutdown()

if __name__ == "__main__":
    start_server()