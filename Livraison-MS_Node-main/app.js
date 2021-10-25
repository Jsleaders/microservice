const express = require('express');
const connectDB = require('./config/db');
const path = require('path');
const app = express();
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const logger = require('morgan');

// Connect Database
connectDB();
// Logger
app.use(logger('dev'));
app.use(bodyParser.json({ limit: '52428800' }));
app.use(
  bodyParser.urlencoded({
    limit: '52428800',
    extended: true,
    parameterLimit: 50000,
  })
);
app.use(express.json());
app.use(express.json({ extended: false }));
process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = 1;

//Euroka configuration

//routes
const Livraison = require('./routes/LivraisonAPI');

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', async (req, res) => {
  res.json({ message: 'Hello i am livraison-service' });
});

app.use('/livraison', Livraison);

const PORT = process.env.PORT || 5000;
const eurekaHelper = require('./eureka-helper');
eurekaHelper.registerWithEureka('livraison-service', PORT);
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
