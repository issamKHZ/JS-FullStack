const express = require('express');

const jwt = require('jsonwebtoken');

const app = express();


app.use(express.json());


// Remplacez cette clé secrète par une clé secrète réelle pour la production

const SECRET_KEY = 'your-secret-key';


app.post('/login', (req, res) => {

 const { email, password } = req.body;


 if (email === 'test@example.com' && password === 'password') {

    const token = jwt.sign({ email }, SECRET_KEY, { expiresIn: '1h' });

    res.json({ token });

 } else {

    res.status(401).json({ error: 'Invalid email or password' });

 }

});


app.listen(3000, () => {
 console.log('Server is running on port 3000');
});