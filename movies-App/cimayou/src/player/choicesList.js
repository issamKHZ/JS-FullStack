import React from 'react';

export default function ChoicesList(props) {
  if (props.EpiQual && props.EpiQual.length > 0) {
    return (
      <div className='choices-list'>
        <table>
          <tbody>
            {props.EpiQual.map((element, index) => (
              <tr key={index}>
                {props.ListAtt === 'episodes' && (
                  <td className={`Background ${(index % 2 === 0) ? '' : 'dark'}`}>{'Episode ' + element.attribut}</td>
                )}
                {(props.ListAtt === 'watchs' || props.ListAtt === 'downloads') && (
                  <td className={`Background ${(index % 2 === 0) ? '' : 'dark'}`}>{element.server + ' ' + element.quality}</td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  } else {
    return <div className='choices-list'></div>;
  }
}