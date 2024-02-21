const express = require('express');
const { loremIpsum } = require('lorem-ipsum');
const cors = require('cors');

const app = express();
const port = 3001;

app.use(cors());

app.get('/generate', (req, res) => {
  try {
    const loremText = loremIpsum();
    res.json({ lorem: loremText });
  } catch (error) {
    console.error('Error generating Lorem Ipsum:', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.listen(port, () => {
  console.log(`Lorem Ipsum service running at http://localhost:${port}`);
});
